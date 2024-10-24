package com.android.abase.network.util;


import android.content.Context;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;


public class SSLSocketClient {
    public static class TrustAll {
        public static SSLSocketFactory createSSLSocketFactory() {
            try {
                SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, getTrustManager(), new SecureRandom());
                return sslContext.getSocketFactory();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private static TrustManager[] getTrustManager() {
            return new TrustManager[]{
                    getX509TrustManager()
            };
        }

        public static X509TrustManager getX509TrustManager() {
            return new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[]{};
                }
            };
        }

        public static HostnameVerifier getHostnameVerifier() {
            return new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            };
        }

        public static  OkHttpClient.Builder getClientBuilder(){
            OkHttpClient.Builder builder=new OkHttpClient.Builder()
                    .hostnameVerifier(getHostnameVerifier())
                    .sslSocketFactory(TrustAll.createSSLSocketFactory(),
                    TrustAll.getX509TrustManager());
            return builder;
        }
    }

    public static class TrustServer {
        public static TrustManager[] getTrustManager(Context context, String filename) {
            try {
                CertificateFactory cf = CertificateFactory.getInstance("X.509");
                InputStream caInput = new BufferedInputStream(context.getAssets().open(filename));
                Certificate ca;
                try {
                    ca = cf.generateCertificate(caInput);
                } finally {
                    caInput.close();
                }
                //
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                keyStore.setCertificateEntry("ca", ca);
                //
                TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                tmf.init(keyStore);
                return tmf.getTrustManagers();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public static SSLSocketFactory createSSLSocketFactory(Context context, String filename) {
            try {
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, getTrustManager(context, filename), null);
                return sslContext.getSocketFactory();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public static X509Certificate getX509CertificateByLocal(Context context, String filename) {
            try {
                X509TrustManager x509TrustManager = (X509TrustManager) getTrustManager(context, filename)[0];
                X509Certificate certificate = x509TrustManager.getAcceptedIssuers()[0];
                return certificate;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        //本地校验
        public static X509TrustManager getX509TrustManagerByLocal(Context context, String filename) {
            try {
                X509TrustManager x509TrustManager = (X509TrustManager) getTrustManager(context, filename)[0];
                X509Certificate certificate = x509TrustManager.getAcceptedIssuers()[0];
                // 证书拥有者
                String subject = certificate.getSubjectDN().getName();
                // 证书颁发者
                String issuer = certificate.getIssuerDN().getName();
                Log.i("X509Certificate", subject + "-->" + issuer);
                return x509TrustManager;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        //和服务器比对校验
        public static X509TrustManager getX509TrustManager(Context context, String filename) {
            return getX509TrustManager(getX509CertificateByLocal(context, filename));
        }

        static X509TrustManager getX509TrustManager(X509Certificate serverCet) {
            return new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                    // 验证服务端证书的有效性
                    if (chain == null) {
                        throw new IllegalArgumentException("Check Server x509Certifications is null");
                    }
                    for (X509Certificate cert : chain) {
                        try {
                            // 校验服务端证书签名是否有问题
                            cert.checkValidity();
                            // 和本地保存的服务端的证书做对比
                            cert.verify(serverCet.getPublicKey());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            };
        }
    }

    //批量信任证书
    public static class TrustBatchServer {
        public static TrustManager[] getTrustManager(Context context, String... filenames) {
            try {
                CertificateFactory cf = CertificateFactory.getInstance("X.509");
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                for (int i = 0; i < filenames.length; i++) {
                    Certificate ca = cf.generateCertificate(context.getAssets().open(filenames[i]));
                    keyStore.setCertificateEntry("ca" + i, ca);
                }
                //
                TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                tmf.init(keyStore);
                return tmf.getTrustManagers();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public static SSLSocketFactory createSSLSocketFactory(Context context, String... filenames) {
            try {
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, getTrustManager(context, filenames), null);
                return sslContext.getSocketFactory();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public static X509Certificate[] getX509CertificateByLocal(Context context, String... filename) {
            try {
                X509TrustManager x509TrustManager = (X509TrustManager) getTrustManager(context, filename)[0];
                X509Certificate[] certificates = x509TrustManager.getAcceptedIssuers();
                return certificates;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        //本地校验
        public static X509TrustManager getX509TrustManagerByLocal(Context context, String... filename) {
            try {
                X509TrustManager x509TrustManager = (X509TrustManager) getTrustManager(context, filename)[0];
                X509Certificate[] certificates = x509TrustManager.getAcceptedIssuers();
                for (int i = 0; i < certificates.length; i++) {
                    X509Certificate certificate = certificates[i];
                    // 证书拥有者
                    String subject = certificate.getSubjectDN().getName();
                    // 证书颁发者
                    String issuer = certificate.getIssuerDN().getName();
                    Log.i("X509Certificate", subject + "-->" + issuer);
                }
                return x509TrustManager;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        //和服务器比对校验
        public static X509TrustManager getX509TrustManager(Context context, String... filename) {
            return getX509TrustManager(getX509CertificateByLocal(context, filename));
        }

        static X509TrustManager getX509TrustManager(X509Certificate[] serverCets) {
            return new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                    // 验证服务端证书的有效性
                    if (chain == null) {
                        throw new IllegalArgumentException("Check Server x509Certifications is null");
                    }
                    for (X509Certificate cert : chain) {
                        try {
                            // 校验服务端证书签名是否有问题
                            cert.checkValidity();
                            // 和本地保存的服务端的证书做对比
                            //TODO
                            //cert.verify(serverCet.getPublicKey());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return serverCets;
                }
            };
        }

        public static HostnameVerifier getHostnameVerifier(String... hostnames) {
            return new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession sslSession) {
                    for (String address:hostnames){
                        if(address.contains(address)){
                            return true;
                        }
                    }
                    return false;
                }
            };
        }
    }

}

