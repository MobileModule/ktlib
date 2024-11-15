package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Dependency provider for <b>achart</b> with <b>com.android.achart:achart</b> coordinates and
     * with version reference <b>achart</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getAchart() {
        return create("achart");
    }

    /**
     * Dependency provider for <b>ander</b> with <b>com.android.ander:ander</b> coordinates and
     * with version reference <b>ander</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getAnder() {
        return create("ander");
    }

    /**
     * Dependency provider for <b>annotations</b> with <b>androidx.annotation:annotation</b> coordinates and
     * with version reference <b>annotation</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getAnnotations() {
        return create("annotations");
    }

    /**
     * Dependency provider for <b>appLog</b> with <b>com.druid.intelink:applog</b> coordinates and
     * with version reference <b>bleLib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getAppLog() {
        return create("appLog");
    }

    /**
     * Dependency provider for <b>appUpdate</b> with <b>com.android.update:appupdate</b> coordinates and
     * with version reference <b>appUpdate</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getAppUpdate() {
        return create("appUpdate");
    }

    /**
     * Dependency provider for <b>appcompat</b> with <b>androidx.appcompat:appcompat</b> coordinates and
     * with version reference <b>appCompat</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getAppcompat() {
        return create("appcompat");
    }

    /**
     * Dependency provider for <b>baseRecyclerViewAdapterHelper</b> with <b>io.github.cymchad:BaseRecyclerViewAdapterHelper4</b> coordinates and
     * with version reference <b>adapterhelper</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getBaseRecyclerViewAdapterHelper() {
        return create("baseRecyclerViewAdapterHelper");
    }

    /**
     * Dependency provider for <b>batteryTimeLine</b> with <b>com.android.batterytimeline:batterytimeline</b> coordinates and
     * with version reference <b>batterytimeline</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getBatteryTimeLine() {
        return create("batteryTimeLine");
    }

    /**
     * Dependency provider for <b>ble</b> with <b>com.druid.intelink:blespp</b> coordinates and
     * with version reference <b>bleLib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getBle() {
        return create("ble");
    }

    /**
     * Dependency provider for <b>bleAct</b> with <b>com.druid.intelink:bleact</b> coordinates and
     * with version reference <b>bleLib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getBleAct() {
        return create("bleAct");
    }

    /**
     * Dependency provider for <b>bleChart</b> with <b>com.android.chart:blerssiv1</b> coordinates and
     * with version reference <b>blechart</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getBleChart() {
        return create("bleChart");
    }

    /**
     * Dependency provider for <b>bleChartV2</b> with <b>com.android.chart:blerssiv2</b> coordinates and
     * with version reference <b>blechartv2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getBleChartV2() {
        return create("bleChartV2");
    }

    /**
     * Dependency provider for <b>bleCompass</b> with <b>com.android.chart:blecompass</b> coordinates and
     * with version reference <b>blecompass</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getBleCompass() {
        return create("bleCompass");
    }

    /**
     * Dependency provider for <b>bleV3Application</b> with <b>com.druid.intelinkv3:blev3-application</b> coordinates and
     * with version reference <b>blev3</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getBleV3Application() {
        return create("bleV3Application");
    }

    /**
     * Dependency provider for <b>bleV3Communication</b> with <b>com.druid.intelinkv3:blev3-communication</b> coordinates and
     * with version reference <b>blev3</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getBleV3Communication() {
        return create("bleV3Communication");
    }

    /**
     * Dependency provider for <b>bleV3Core</b> with <b>com.druid.intelinkv3:blev3-core</b> coordinates and
     * with version reference <b>blev3</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getBleV3Core() {
        return create("bleV3Core");
    }

    /**
     * Dependency provider for <b>bleV3Log</b> with <b>com.druid.intelinkv3:blev3-log</b> coordinates and
     * with version reference <b>blev3</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getBleV3Log() {
        return create("bleV3Log");
    }

    /**
     * Dependency provider for <b>bleV3Protocol</b> with <b>com.druid.intelinkv3:blev3-protocol</b> coordinates and
     * with version reference <b>blev3</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getBleV3Protocol() {
        return create("bleV3Protocol");
    }

    /**
     * Dependency provider for <b>bleV3Util</b> with <b>com.druid.intelinkv3:blev3-util</b> coordinates and
     * with version reference <b>blev3</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getBleV3Util() {
        return create("bleV3Util");
    }

    /**
     * Dependency provider for <b>blutooth</b> with <b>com.druid.intelink:bluetoothspp</b> coordinates and
     * with version reference <b>bleLib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getBlutooth() {
        return create("blutooth");
    }

    /**
     * Dependency provider for <b>camera2</b> with <b>androidx.camera:camera-camera2</b> coordinates and
     * with version reference <b>cameraX2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getCamera2() {
        return create("camera2");
    }

    /**
     * Dependency provider for <b>cameraCore</b> with <b>androidx.camera:camera-core</b> coordinates and
     * with version reference <b>cameraXCore</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getCameraCore() {
        return create("cameraCore");
    }

    /**
     * Dependency provider for <b>cameraLifeCycle</b> with <b>androidx.camera:camera-lifecycle</b> coordinates and
     * with version reference <b>cameraXLifeCycle</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getCameraLifeCycle() {
        return create("cameraLifeCycle");
    }

    /**
     * Dependency provider for <b>cameraView</b> with <b>androidx.camera:camera-view</b> coordinates and
     * with version reference <b>cameraXView</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getCameraView() {
        return create("cameraView");
    }

    /**
     * Dependency provider for <b>cardview</b> with <b>androidx.cardview:cardview</b> coordinates and
     * with version reference <b>cardview</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getCardview() {
        return create("cardview");
    }

    /**
     * Dependency provider for <b>colorPicker</b> with <b>com.android.colorpicker:picker</b> coordinates and
     * with version reference <b>colorpicker</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getColorPicker() {
        return create("colorPicker");
    }

    /**
     * Dependency provider for <b>constraintlayout</b> with <b>androidx.constraintlayout:constraintlayout</b> coordinates and
     * with version reference <b>constraintlayout</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getConstraintlayout() {
        return create("constraintlayout");
    }

    /**
     * Dependency provider for <b>coordinatorlayout</b> with <b>androidx.coordinatorlayout:coordinatorlayout</b> coordinates and
     * with version reference <b>coordinatorlayout</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getCoordinatorlayout() {
        return create("coordinatorlayout");
    }

    /**
     * Dependency provider for <b>core</b> with <b>androidx.core:core</b> coordinates and
     * with version reference <b>core</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getCore() {
        return create("core");
    }

    /**
     * Dependency provider for <b>coreKtx</b> with <b>androidx.core:core-ktx</b> coordinates and
     * with version reference <b>coreKtx</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getCoreKtx() {
        return create("coreKtx");
    }

    /**
     * Dependency provider for <b>cube</b> with <b>in.srain.cube:clog</b> coordinates and
     * with version reference <b>cube</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getCube() {
        return create("cube");
    }

    /**
     * Dependency provider for <b>daoLib</b> with <b>com.android.druiddao:druiddao</b> coordinates and
     * with version reference <b>daolib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getDaoLib() {
        return create("daoLib");
    }

    /**
     * Dependency provider for <b>dimenX2</b> with <b>com.android.dimen:dimenx2</b> coordinates and
     * with version reference <b>dimenx2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getDimenX2() {
        return create("dimenX2");
    }

    /**
     * Dependency provider for <b>dimenX3</b> with <b>com.android.dimen:dimenx3</b> coordinates and
     * with version reference <b>dimenx3</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getDimenX3() {
        return create("dimenX3");
    }

    /**
     * Dependency provider for <b>druidHttp</b> with <b>com.android.http:druidhttp</b> coordinates and
     * with version reference <b>druidhttp</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getDruidHttp() {
        return create("druidHttp");
    }

    /**
     * Dependency provider for <b>druidViewPager2</b> with <b>com.android.bannar:viewpager2</b> coordinates and
     * with version reference <b>druidbanner</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getDruidViewPager2() {
        return create("druidViewPager2");
    }

    /**
     * Dependency provider for <b>druidZxing</b> with <b>com.android.zxing:zxing</b> coordinates and
     * with version reference <b>druidzxing</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getDruidZxing() {
        return create("druidZxing");
    }

    /**
     * Dependency provider for <b>dynamicAnimationsKtx</b> with <b>androidx.dynamicanimation:dynamicanimation-ktx</b> coordinates and
     * with version reference <b>dynamicAnimationsKtx</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getDynamicAnimationsKtx() {
        return create("dynamicAnimationsKtx");
    }

    /**
     * Dependency provider for <b>exifinterface</b> with <b>androidx.exifinterface:exifinterface</b> coordinates and
     * with version reference <b>exifinterface</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getExifinterface() {
        return create("exifinterface");
    }

    /**
     * Dependency provider for <b>fastjson</b> with <b>com.alibaba:fastjson</b> coordinates and
     * with version reference <b>fastjson</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getFastjson() {
        return create("fastjson");
    }

    /**
     * Dependency provider for <b>folderManager</b> with <b>com.android.foldermanager:folder</b> coordinates and
     * with version reference <b>foldermanager</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getFolderManager() {
        return create("folderManager");
    }

    /**
     * Dependency provider for <b>fragmentKtx</b> with <b>androidx.fragment:fragment-ktx</b> coordinates and
     * with version reference <b>fragmentKtx</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getFragmentKtx() {
        return create("fragmentKtx");
    }

    /**
     * Dependency provider for <b>freshView</b> with <b>com.android.refreshView:refresh</b> coordinates and
     * with version reference <b>freshView</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getFreshView() {
        return create("freshView");
    }

    /**
     * Dependency provider for <b>gifImage</b> with <b>pl.droidsonroids.gif:android-gif-drawable</b> coordinates and
     * with version reference <b>gifImage</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getGifImage() {
        return create("gifImage");
    }

    /**
     * Dependency provider for <b>glide</b> with <b>com.github.bumptech.glide:glide</b> coordinates and
     * with version reference <b>glide</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getGlide() {
        return create("glide");
    }

    /**
     * Dependency provider for <b>googleLocation</b> with <b>com.google.android.gms:play-services-location</b> coordinates and
     * with version reference <b>googleLocation</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getGoogleLocation() {
        return create("googleLocation");
    }

    /**
     * Dependency provider for <b>googleMap</b> with <b>com.google.android.gms:play-services-maps</b> coordinates and
     * with version reference <b>googleMap</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getGoogleMap() {
        return create("googleMap");
    }

    /**
     * Dependency provider for <b>googleUtils</b> with <b>com.druid.map:google-utils</b> coordinates and
     * with version reference <b>mapview</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getGoogleUtils() {
        return create("googleUtils");
    }

    /**
     * Dependency provider for <b>greenDao</b> with <b>org.greenrobot:greendao</b> coordinates and
     * with version reference <b>greendao</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getGreenDao() {
        return create("greenDao");
    }

    /**
     * Dependency provider for <b>greenDaoHelper</b> with <b>io.github.yuweiguocn:GreenDaoUpgradeHelper</b> coordinates and
     * with version reference <b>greendaohelper</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getGreenDaoHelper() {
        return create("greenDaoHelper");
    }

    /**
     * Dependency provider for <b>gson</b> with <b>com.google.code.gson:gson</b> coordinates and
     * with version reference <b>gson</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getGson() {
        return create("gson");
    }

    /**
     * Dependency provider for <b>imageViewer</b> with <b>com.druid.image:imageviewer</b> coordinates and
     * with version reference <b>imageviewer</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getImageViewer() {
        return create("imageViewer");
    }

    /**
     * Dependency provider for <b>imageloader</b> with <b>com.nostra13.universalimageloader:universal-image-loader</b> coordinates and
     * with version reference <b>imageloader</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getImageloader() {
        return create("imageloader");
    }

    /**
     * Dependency provider for <b>interpolator</b> with <b>androidx.interpolator:interpolator</b> coordinates and
     * with version reference <b>interpolator</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getInterpolator() {
        return create("interpolator");
    }

    /**
     * Dependency provider for <b>junit</b> with <b>junit:junit</b> coordinates and
     * with version reference <b>junit</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getJunit() {
        return create("junit");
    }

    /**
     * Dependency provider for <b>kotlin</b> with <b>org.jetbrains.kotlin:kotlin-stdlib-jdk7</b> coordinates and
     * with version reference <b>kotlin</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getKotlin() {
        return create("kotlin");
    }

    /**
     * Dependency provider for <b>kotlinReflect</b> with <b>org.jetbrains.kotlin:kotlin-reflect</b> coordinates and
     * with version reference <b>kotlin</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getKotlinReflect() {
        return create("kotlinReflect");
    }

    /**
     * Dependency provider for <b>kotlinStdlib</b> with <b>org.jetbrains.kotlin:kotlin-stdlib</b> coordinates and
     * with version reference <b>kotlin</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getKotlinStdlib() {
        return create("kotlinStdlib");
    }

    /**
     * Dependency provider for <b>ktLib</b> with <b>com.android.abase:ktlib</b> coordinates and
     * with version reference <b>ktlib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getKtLib() {
        return create("ktLib");
    }

    /**
     * Dependency provider for <b>leakCanary</b> with <b>com.squareup.leakcanary:leakcanary-android</b> coordinates and
     * with version reference <b>leaks</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getLeakCanary() {
        return create("leakCanary");
    }

    /**
     * Dependency provider for <b>lifecycleCommonJava8</b> with <b>androidx.lifecycle:lifecycle-common-java8</b> coordinates and
     * with version reference <b>lifecycleCommonJava8</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getLifecycleCommonJava8() {
        return create("lifecycleCommonJava8");
    }

    /**
     * Dependency provider for <b>lifecycleExtensions</b> with <b>androidx.lifecycle:lifecycle-extensions</b> coordinates and
     * with version reference <b>lifecycleExtensions</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getLifecycleExtensions() {
        return create("lifecycleExtensions");
    }

    /**
     * Dependency provider for <b>lifecycleLivedataKtx</b> with <b>androidx.lifecycle:lifecycle-livedata-ktx</b> coordinates and
     * with version reference <b>lifecycleLiveDataKtx</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getLifecycleLivedataKtx() {
        return create("lifecycleLivedataKtx");
    }

    /**
     * Dependency provider for <b>lifecycleReactivestreams</b> with <b>androidx.lifecycle:lifecycle-reactivestreams</b> coordinates and
     * with version reference <b>lifecycleReactivestreams</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getLifecycleReactivestreams() {
        return create("lifecycleReactivestreams");
    }

    /**
     * Dependency provider for <b>lifecycleRuntimeKtx</b> with <b>androidx.lifecycle:lifecycle-runtime-ktx</b> coordinates and
     * with version reference <b>lifecycleRuntimeKtx</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getLifecycleRuntimeKtx() {
        return create("lifecycleRuntimeKtx");
    }

    /**
     * Dependency provider for <b>lifecycleViewmodelKtx</b> with <b>androidx.lifecycle:lifecycle-viewmodel-ktx</b> coordinates and
     * with version reference <b>lifecycleViewmodelKtx</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getLifecycleViewmodelKtx() {
        return create("lifecycleViewmodelKtx");
    }

    /**
     * Dependency provider for <b>liveDataUnpeek</b> with <b>com.kunminx.archi:unpeek-livedata</b> coordinates and
     * with version reference <b>liveDataUnpeek</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getLiveDataUnpeek() {
        return create("liveDataUnpeek");
    }

    /**
     * Dependency provider for <b>loadSir</b> with <b>com.kingja.loadsir:loadsir</b> coordinates and
     * with version reference <b>loadsir</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getLoadSir() {
        return create("loadSir");
    }

    /**
     * Dependency provider for <b>localLan</b> with <b>com.android.locallan:locallan</b> coordinates and
     * with version reference <b>locallan</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getLocalLan() {
        return create("localLan");
    }

    /**
     * Dependency provider for <b>locationCore</b> with <b>com.gps.location:location</b> coordinates and
     * with version reference <b>gpslocation</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getLocationCore() {
        return create("locationCore");
    }

    /**
     * Dependency provider for <b>locationGoogle</b> with <b>com.gps.location:google</b> coordinates and
     * with version reference <b>gpslocation</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getLocationGoogle() {
        return create("locationGoogle");
    }

    /**
     * Dependency provider for <b>locationTech</b> with <b>org.locationtech.jts:jts-core</b> coordinates and
     * with version reference <b>locationtech</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getLocationTech() {
        return create("locationTech");
    }

    /**
     * Dependency provider for <b>locationTencent</b> with <b>com.gps.location:tencent</b> coordinates and
     * with version reference <b>gpslocation</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getLocationTencent() {
        return create("locationTencent");
    }

    /**
     * Dependency provider for <b>mPChart</b> with <b>com.android.mpchart:mpchart</b> coordinates and
     * with version reference <b>mpchart</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMPChart() {
        return create("mPChart");
    }

    /**
     * Dependency provider for <b>mapBox</b> with <b>com.druid.map:mapboxkt</b> coordinates and
     * with version reference <b>mapview</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapBox() {
        return create("mapBox");
    }

    /**
     * Dependency provider for <b>mapCore</b> with <b>com.druid.map:coremap</b> coordinates and
     * with version reference <b>mapview</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapCore() {
        return create("mapCore");
    }

    /**
     * Dependency provider for <b>mapGoogle</b> with <b>com.druid.map:mapgoogle</b> coordinates and
     * with version reference <b>mapview</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapGoogle() {
        return create("mapGoogle");
    }

    /**
     * Dependency provider for <b>mapboxAnnotations</b> with <b>com.mapbox.base:annotations</b> coordinates and
     * with version reference <b>mapboxBase</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapboxAnnotations() {
        return create("mapboxAnnotations");
    }

    /**
     * Dependency provider for <b>mapboxAnnotationsProcessor</b> with <b>com.mapbox.base:annotations-processor</b> coordinates and
     * with version reference <b>mapboxBase</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapboxAnnotationsProcessor() {
        return create("mapboxAnnotationsProcessor");
    }

    /**
     * Dependency provider for <b>mapboxBase</b> with <b>com.mapbox.base:common</b> coordinates and
     * with version reference <b>mapboxBase</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapboxBase() {
        return create("mapboxBase");
    }

    /**
     * Dependency provider for <b>mapboxGeoJSON</b> with <b>com.mapbox.mapboxsdk:mapbox-sdk-geojson</b> coordinates and
     * with version reference <b>mapboxJavaServices</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapboxGeoJSON() {
        return create("mapboxGeoJSON");
    }

    /**
     * Dependency provider for <b>mapboxGestures</b> with <b>com.mapbox.mapboxsdk:mapbox-android-gestures</b> coordinates and
     * with version reference <b>mapboxGestures</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapboxGestures() {
        return create("mapboxGestures");
    }

    /**
     * Dependency provider for <b>mapboxJavaTurf</b> with <b>com.mapbox.mapboxsdk:mapbox-sdk-turf</b> coordinates and
     * with version reference <b>mapboxJavaServices</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapboxJavaTurf() {
        return create("mapboxJavaTurf");
    }

    /**
     * Dependency provider for <b>mapboxLocation</b> with <b>com.mapbox.mapboxsdk:mapbox-android-plugin-localization-v9</b> coordinates and
     * with version reference <b>mapboxLocation</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapboxLocation() {
        return create("mapboxLocation");
    }

    /**
     * Dependency provider for <b>mapboxPluginAnnotation</b> with <b>com.mapbox.mapboxsdk:mapbox-android-plugin-annotation-v9</b> coordinates and
     * with version reference <b>mapboxPluginAnnotation</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapboxPluginAnnotation() {
        return create("mapboxPluginAnnotation");
    }

    /**
     * Dependency provider for <b>mapboxPluginMarkerView</b> with <b>com.mapbox.mapboxsdk:mapbox-android-plugin-markerview-v9</b> coordinates and
     * with version reference <b>mapboxPluginMarkerView</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapboxPluginMarkerView() {
        return create("mapboxPluginMarkerView");
    }

    /**
     * Dependency provider for <b>mapboxServices</b> with <b>com.mapbox.mapboxsdk:mapbox-sdk-services</b> coordinates and
     * with version reference <b>mapboxJavaServices</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapboxServices() {
        return create("mapboxServices");
    }

    /**
     * Dependency provider for <b>mapboxTurf</b> with <b>com.mapbox.mapboxsdk:mapbox-sdk-turf</b> coordinates and
     * with version reference <b>mapboxTurf</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapboxTurf() {
        return create("mapboxTurf");
    }

    /**
     * Dependency provider for <b>mapboxV10</b> with <b>com.mapbox.maps:android</b> coordinates and
     * with version reference <b>mapboxSdxV10</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapboxV10() {
        return create("mapboxV10");
    }

    /**
     * Dependency provider for <b>mapboxV11</b> with <b>com.mapbox.maps:android</b> coordinates and
     * with version reference <b>mapboxV11</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapboxV11() {
        return create("mapboxV11");
    }

    /**
     * Dependency provider for <b>mapboxV9</b> with <b>com.mapbox.mapboxsdk:mapbox-android-sdk</b> coordinates and
     * with version reference <b>mapboxSdxV9</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMapboxV9() {
        return create("mapboxV9");
    }

    /**
     * Dependency provider for <b>material</b> with <b>com.google.android.material:material</b> coordinates and
     * with version reference <b>material</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMaterial() {
        return create("material");
    }

    /**
     * Dependency provider for <b>mp4Parse</b> with <b>com.googlecode.mp4parser:isoparser</b> coordinates and
     * with version reference <b>mp4parser</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMp4Parse() {
        return create("mp4Parse");
    }

    /**
     * Dependency provider for <b>navigationCommonKtx</b> with <b>androidx.navigation:navigation-common-ktx</b> coordinates and
     * with version reference <b>navigationFragment</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getNavigationCommonKtx() {
        return create("navigationCommonKtx");
    }

    /**
     * Dependency provider for <b>navigationUIKtx</b> with <b>androidx.navigation:okhttp</b> coordinates and
     * with version reference <b>navigationUiKtx</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getNavigationUIKtx() {
        return create("navigationUIKtx");
    }

    /**
     * Dependency provider for <b>navigator</b> with <b>com.android.navigator:navigator</b> coordinates and
     * with version reference <b>navigator</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getNavigator() {
        return create("navigator");
    }

    /**
     * Dependency provider for <b>nineoldandroids</b> with <b>com.nineoldandroids:library</b> coordinates and
     * with version reference <b>nineoldandroids</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getNineoldandroids() {
        return create("nineoldandroids");
    }

    /**
     * Dependency provider for <b>noHttp</b> with <b>com.android.nohttp:nohttp</b> coordinates and
     * with version reference <b>nohttp</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getNoHttp() {
        return create("noHttp");
    }

    /**
     * Dependency provider for <b>nordic</b> with <b>com.druid.intelink:nordic-ble</b> coordinates and
     * with version reference <b>bleLib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getNordic() {
        return create("nordic");
    }

    /**
     * Dependency provider for <b>okhttp3</b> with <b>com.squareup.okhttp3:okhttp</b> coordinates and
     * with version reference <b>okhttp3</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getOkhttp3() {
        return create("okhttp3");
    }

    /**
     * Dependency provider for <b>okhttp3Connection</b> with <b>com.squareup.okhttp3:okhttp-urlconnection</b> coordinates and
     * with version reference <b>okhttp3Connection</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getOkhttp3Connection() {
        return create("okhttp3Connection");
    }

    /**
     * Dependency provider for <b>okhttp3Interagtion</b> with <b>com.github.bumptech.glide:okhttp3-integration</b> coordinates and
     * with version reference <b>okhttp3Interagtion</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getOkhttp3Interagtion() {
        return create("okhttp3Interagtion");
    }

    /**
     * Dependency provider for <b>ota</b> with <b>com.druid.intelink:ota</b> coordinates and
     * with version reference <b>bleLib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getOta() {
        return create("ota");
    }

    /**
     * Dependency provider for <b>persistentCookieJar</b> with <b>com.github.franmontiel:PersistentCookieJar</b> coordinates and
     * with version reference <b>persistentCookieJar</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getPersistentCookieJar() {
        return create("persistentCookieJar");
    }

    /**
     * Dependency provider for <b>photoView</b> with <b>com.github.chrisbanes:PhotoView</b> coordinates and
     * with version reference <b>photoview</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getPhotoView() {
        return create("photoView");
    }

    /**
     * Dependency provider for <b>picasso</b> with <b>com.squareup.picasso:picasso</b> coordinates and
     * with version reference <b>picasso</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getPicasso() {
        return create("picasso");
    }

    /**
     * Dependency provider for <b>pickerView</b> with <b>com.android.pickerview:pickerview</b> coordinates and
     * with version reference <b>pickerview</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getPickerView() {
        return create("pickerView");
    }

    /**
     * Dependency provider for <b>protobuf</b> with <b>com.google.protobuf:protobuf-java</b> coordinates and
     * with version reference <b>protobuf</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getProtobuf() {
        return create("protobuf");
    }

    /**
     * Dependency provider for <b>protocol</b> with <b>com.druid.intelink:protocol</b> coordinates and
     * with version reference <b>bleLib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getProtocol() {
        return create("protocol");
    }

    /**
     * Dependency provider for <b>qrCodeCamera</b> with <b>com.druid.qrcode:camera</b> coordinates and
     * with version reference <b>qrcodeLib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getQrCodeCamera() {
        return create("qrCodeCamera");
    }

    /**
     * Dependency provider for <b>qrCodeLib</b> with <b>com.druid.qrcode:qrcode</b> coordinates and
     * with version reference <b>qrcodeLib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getQrCodeLib() {
        return create("qrCodeLib");
    }

    /**
     * Dependency provider for <b>qrCodeOpenCV</b> with <b>com.druid.qrcode:opencv</b> coordinates and
     * with version reference <b>qrcodeLib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getQrCodeOpenCV() {
        return create("qrCodeOpenCV");
    }

    /**
     * Dependency provider for <b>qrCodeScanning</b> with <b>com.druid.qrcode:qrcode-scanning</b> coordinates and
     * with version reference <b>qrcodeLib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getQrCodeScanning() {
        return create("qrCodeScanning");
    }

    /**
     * Dependency provider for <b>recyclerview</b> with <b>androidx.recyclerview:recyclerview</b> coordinates and
     * with version reference <b>recyclerview</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getRecyclerview() {
        return create("recyclerview");
    }

    /**
     * Dependency provider for <b>retrofit2</b> with <b>com.squareup.retrofit2:retrofit</b> coordinates and
     * with version reference <b>retrofit2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getRetrofit2() {
        return create("retrofit2");
    }

    /**
     * Dependency provider for <b>retrofit2GSON</b> with <b>com.squareup.retrofit2:converter-gson</b> coordinates and
     * with version reference <b>retrofit2Gson</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getRetrofit2GSON() {
        return create("retrofit2GSON");
    }

    /**
     * Dependency provider for <b>retrofitUrlManager</b> with <b>me.jessyan:retrofit-url-manager</b> coordinates and
     * with version reference <b>retrofitUrlManager</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getRetrofitUrlManager() {
        return create("retrofitUrlManager");
    }

    /**
     * Dependency provider for <b>router</b> with <b>com.druid.router:router</b> coordinates and
     * with version reference <b>router</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getRouter() {
        return create("router");
    }

    /**
     * Dependency provider for <b>rxandroid</b> with <b>io.reactivex.rxjava2:rxandroid</b> coordinates and
     * with version reference <b>rxandroid</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getRxandroid() {
        return create("rxandroid");
    }

    /**
     * Dependency provider for <b>rxjava</b> with <b>io.reactivex.rxjava2:rxjava</b> coordinates and
     * with version reference <b>rxjava</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getRxjava() {
        return create("rxjava");
    }

    /**
     * Dependency provider for <b>rxkotlin</b> with <b>io.reactivex.rxjava2:rxkotlin</b> coordinates and
     * with version reference <b>rxkotlin</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getRxkotlin() {
        return create("rxkotlin");
    }

    /**
     * Dependency provider for <b>scaleImageView</b> with <b>com.davemorrissey.labs:subsampling-scale-image-view</b> coordinates and
     * with version reference <b>scaleimageview</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getScaleImageView() {
        return create("scaleImageView");
    }

    /**
     * Dependency provider for <b>scanner</b> with <b>com.druid.intelink:scanner</b> coordinates and
     * with version reference <b>bleLib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getScanner() {
        return create("scanner");
    }

    /**
     * Dependency provider for <b>scrollTable</b> with <b>com.druid.scrolltable:scrolltable</b> coordinates and
     * with version reference <b>scrolltable</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getScrollTable() {
        return create("scrollTable");
    }

    /**
     * Dependency provider for <b>sdCard</b> with <b>com.android.sdcard:sdcard</b> coordinates and
     * with version reference <b>sdcard</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSdCard() {
        return create("sdCard");
    }

    /**
     * Dependency provider for <b>seekBar</b> with <b>com.zhouyou:signseekbar</b> coordinates and
     * with version reference <b>signseekbar</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSeekBar() {
        return create("seekBar");
    }

    /**
     * Dependency provider for <b>selectPhotos</b> with <b>com.android.locallan:selectphotos</b> coordinates and
     * with version reference <b>locallan</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSelectPhotos() {
        return create("selectPhotos");
    }

    /**
     * Dependency provider for <b>shimmerlayout</b> with <b>io.supercharge:shimmerlayout</b> coordinates and
     * with version reference <b>shimmerlayout</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getShimmerlayout() {
        return create("shimmerlayout");
    }

    /**
     * Dependency provider for <b>skeleton</b> with <b>com.ethanhua:skeleton</b> coordinates and
     * with version reference <b>skeleton</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSkeleton() {
        return create("skeleton");
    }

    /**
     * Dependency provider for <b>slidingtab</b> with <b>com.android.bannar:slidingtab</b> coordinates and
     * with version reference <b>druidbanner</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSlidingtab() {
        return create("slidingtab");
    }

    /**
     * Dependency provider for <b>smartFreshDrawablePaint</b> with <b>com.smartfresh.v2:drawable-paint</b> coordinates and
     * with version reference <b>smartfeshv2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSmartFreshDrawablePaint() {
        return create("smartFreshDrawablePaint");
    }

    /**
     * Dependency provider for <b>smartFreshDrawablePath</b> with <b>com.smartfresh.v2:drawable-path</b> coordinates and
     * with version reference <b>smartfeshv2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSmartFreshDrawablePath() {
        return create("smartFreshDrawablePath");
    }

    /**
     * Dependency provider for <b>smartFreshDruid</b> with <b>com.smartfresh.v2:druid</b> coordinates and
     * with version reference <b>smartfeshv2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSmartFreshDruid() {
        return create("smartFreshDruid");
    }

    /**
     * Dependency provider for <b>smartFreshFooter</b> with <b>com.smartfresh.v2:footer</b> coordinates and
     * with version reference <b>smartfeshv2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSmartFreshFooter() {
        return create("smartFreshFooter");
    }

    /**
     * Dependency provider for <b>smartFreshFooterBall</b> with <b>com.smartfresh.v2:footer-ball</b> coordinates and
     * with version reference <b>smartfeshv2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSmartFreshFooterBall() {
        return create("smartFreshFooterBall");
    }

    /**
     * Dependency provider for <b>smartFreshFooterClassics</b> with <b>com.smartfresh.v2:footer-classics</b> coordinates and
     * with version reference <b>smartfeshv2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSmartFreshFooterClassics() {
        return create("smartFreshFooterClassics");
    }

    /**
     * Dependency provider for <b>smartFreshHeader</b> with <b>com.smartfresh.v2:header</b> coordinates and
     * with version reference <b>smartfeshv2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSmartFreshHeader() {
        return create("smartFreshHeader");
    }

    /**
     * Dependency provider for <b>smartFreshHeaderClassics</b> with <b>com.smartfresh.v2:header-clasics</b> coordinates and
     * with version reference <b>smartfeshv2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSmartFreshHeaderClassics() {
        return create("smartFreshHeaderClassics");
    }

    /**
     * Dependency provider for <b>smartFreshHeaderFalsify</b> with <b>com.smartfresh.v2:header-falsify</b> coordinates and
     * with version reference <b>smartfeshv2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSmartFreshHeaderFalsify() {
        return create("smartFreshHeaderFalsify");
    }

    /**
     * Dependency provider for <b>smartFreshHeaderMaterial</b> with <b>com.smartfresh.v2:header-material</b> coordinates and
     * with version reference <b>smartfeshv2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSmartFreshHeaderMaterial() {
        return create("smartFreshHeaderMaterial");
    }

    /**
     * Dependency provider for <b>smartFreshHeaderRadar</b> with <b>com.smartfresh.v2:header-radar</b> coordinates and
     * with version reference <b>smartfeshv2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSmartFreshHeaderRadar() {
        return create("smartFreshHeaderRadar");
    }

    /**
     * Dependency provider for <b>smartFreshHeaderTwoLevel</b> with <b>com.smartfresh.v2:header-twolevel</b> coordinates and
     * with version reference <b>smartfeshv2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSmartFreshHeaderTwoLevel() {
        return create("smartFreshHeaderTwoLevel");
    }

    /**
     * Dependency provider for <b>smartFreshLayout</b> with <b>com.smartfresh.v2:layout</b> coordinates and
     * with version reference <b>smartfeshv2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSmartFreshLayout() {
        return create("smartFreshLayout");
    }

    /**
     * Dependency provider for <b>smartFreshLayoutKernel</b> with <b>com.smartfresh.v2:layout-kernel</b> coordinates and
     * with version reference <b>smartfeshv2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSmartFreshLayoutKernel() {
        return create("smartFreshLayoutKernel");
    }

    /**
     * Dependency provider for <b>snackBar</b> with <b>com.android.snackbar:snackbar</b> coordinates and
     * with version reference <b>snackbar</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSnackBar() {
        return create("snackBar");
    }

    /**
     * Dependency provider for <b>socketClient</b> with <b>com.druid.socket:socket-client</b> coordinates and
     * with version reference <b>socket</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSocketClient() {
        return create("socketClient");
    }

    /**
     * Dependency provider for <b>socketCommon</b> with <b>com.druid.socket:socket-common-interface</b> coordinates and
     * with version reference <b>socket</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSocketCommon() {
        return create("socketCommon");
    }

    /**
     * Dependency provider for <b>socketCore</b> with <b>com.druid.socket:socket-core</b> coordinates and
     * with version reference <b>socket</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSocketCore() {
        return create("socketCore");
    }

    /**
     * Dependency provider for <b>sqliteKtx</b> with <b>androidx.sqlite:sqlite-ktx</b> coordinates and
     * with version reference <b>sqlitektx</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSqliteKtx() {
        return create("sqliteKtx");
    }

    /**
     * Dependency provider for <b>styleTheme</b> with <b>com.druid.style:theme</b> coordinates and
     * with version reference <b>styletheme</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getStyleTheme() {
        return create("styleTheme");
    }

    /**
     * Dependency provider for <b>swipeRecyclerview</b> with <b>com.android.refreshView:recyclerview</b> coordinates and
     * with version reference <b>freshView</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSwipeRecyclerview() {
        return create("swipeRecyclerview");
    }

    /**
     * Dependency provider for <b>swiperefreshLayout</b> with <b>androidx.swiperefreshlayout:swiperefreshlayout</b> coordinates and
     * with version reference <b>swiperefreshlayout</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSwiperefreshLayout() {
        return create("swiperefreshLayout");
    }

    /**
     * Dependency provider for <b>tableView</b> with <b>com.android.tableview:table</b> coordinates and
     * with version reference <b>table</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getTableView() {
        return create("tableView");
    }

    /**
     * Dependency provider for <b>tencentLocation</b> with <b>com.tencent.map.geolocation:TencentLocationSdk-openplatform</b> coordinates and
     * with version reference <b>tencentlocation</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getTencentLocation() {
        return create("tencentLocation");
    }

    /**
     * Dependency provider for <b>timeBar</b> with <b>com.druid.mark:timebar</b> coordinates and
     * with version reference <b>timebarLib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getTimeBar() {
        return create("timeBar");
    }

    /**
     * Dependency provider for <b>timeChart</b> with <b>com.druid.mark:timechart</b> coordinates and
     * with version reference <b>timebarLib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getTimeChart() {
        return create("timeChart");
    }

    /**
     * Dependency provider for <b>timeCore</b> with <b>com.druid.mark:timecore</b> coordinates and
     * with version reference <b>timebarLib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getTimeCore() {
        return create("timeCore");
    }

    /**
     * Dependency provider for <b>timePaint</b> with <b>com.druid.mark:timepaint</b> coordinates and
     * with version reference <b>timebarLib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getTimePaint() {
        return create("timePaint");
    }

    /**
     * Dependency provider for <b>tts</b> with <b>com.android.tts:tts</b> coordinates and
     * with version reference <b>tts</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getTts() {
        return create("tts");
    }

    /**
     * Dependency provider for <b>videoPlayer</b> with <b>cn.jzvd:jiaozivideoplayer</b> coordinates and
     * with version reference <b>jiaozivideoplayer</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getVideoPlayer() {
        return create("videoPlayer");
    }

    /**
     * Dependency provider for <b>viewGuid</b> with <b>com.android.viewguid:viewguid</b> coordinates and
     * with version reference <b>viewguid</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getViewGuid() {
        return create("viewGuid");
    }

    /**
     * Dependency provider for <b>viewpager</b> with <b>androidx.viewpager:viewpager</b> coordinates and
     * with version reference <b>viewpager</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getViewpager() {
        return create("viewpager");
    }

    /**
     * Dependency provider for <b>viewpager2</b> with <b>androidx.viewpager2:viewpager2</b> coordinates and
     * with version reference <b>viewpager2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getViewpager2() {
        return create("viewpager2");
    }

    /**
     * Dependency provider for <b>wcdb</b> with <b>com.tencent.wcdb:main</b> coordinates and
     * with version reference <b>wcdb</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getWcdb() {
        return create("wcdb");
    }

    /**
     * Dependency provider for <b>wcdbAnnotation</b> with <b>com.tencent.wcdb:annotation</b> coordinates and
     * with version reference <b>wcdb</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getWcdbAnnotation() {
        return create("wcdbAnnotation");
    }

    /**
     * Dependency provider for <b>wcdbCompiler</b> with <b>com.tencent.wcdb:compiler</b> coordinates and
     * with version reference <b>wcdb</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getWcdbCompiler() {
        return create("wcdbCompiler");
    }

    /**
     * Dependency provider for <b>widget</b> with <b>com.druid.control:widget</b> coordinates and
     * with version reference <b>widget</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getWidget() {
        return create("widget");
    }

    /**
     * Dependency provider for <b>zxing</b> with <b>com.google.zxing:core</b> coordinates and
     * with version reference <b>zxing</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getZxing() {
        return create("zxing");
    }

    /**
     * Group of libraries at <b>androidx</b>
     */
    public AndroidxLibraryAccessors getAndroidx() {
        return laccForAndroidxLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxActivityLibraryAccessors laccForAndroidxActivityLibraryAccessors = new AndroidxActivityLibraryAccessors(owner);
        private final AndroidxComposeLibraryAccessors laccForAndroidxComposeLibraryAccessors = new AndroidxComposeLibraryAccessors(owner);
        private final AndroidxConstraintlayoutLibraryAccessors laccForAndroidxConstraintlayoutLibraryAccessors = new AndroidxConstraintlayoutLibraryAccessors(owner);
        private final AndroidxEspressoLibraryAccessors laccForAndroidxEspressoLibraryAccessors = new AndroidxEspressoLibraryAccessors(owner);
        private final AndroidxNavigationLibraryAccessors laccForAndroidxNavigationLibraryAccessors = new AndroidxNavigationLibraryAccessors(owner);
        private final AndroidxUiLibraryAccessors laccForAndroidxUiLibraryAccessors = new AndroidxUiLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit</b> with <b>androidx.test.ext:junit</b> coordinates and
         * with version reference <b>junitVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() {
            return create("androidx.junit");
        }

        /**
         * Dependency provider for <b>material3</b> with <b>androidx.compose.material3:material3</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial3() {
            return create("androidx.material3");
        }

        /**
         * Group of libraries at <b>androidx.activity</b>
         */
        public AndroidxActivityLibraryAccessors getActivity() {
            return laccForAndroidxActivityLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.compose</b>
         */
        public AndroidxComposeLibraryAccessors getCompose() {
            return laccForAndroidxComposeLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.constraintlayout</b>
         */
        public AndroidxConstraintlayoutLibraryAccessors getConstraintlayout() {
            return laccForAndroidxConstraintlayoutLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.espresso</b>
         */
        public AndroidxEspressoLibraryAccessors getEspresso() {
            return laccForAndroidxEspressoLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.navigation</b>
         */
        public AndroidxNavigationLibraryAccessors getNavigation() {
            return laccForAndroidxNavigationLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.ui</b>
         */
        public AndroidxUiLibraryAccessors getUi() {
            return laccForAndroidxUiLibraryAccessors;
        }

    }

    public static class AndroidxActivityLibraryAccessors extends SubDependencyFactory {

        public AndroidxActivityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.activity:activity-compose</b> coordinates and
         * with version reference <b>activityCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("androidx.activity.compose");
        }

    }

    public static class AndroidxComposeLibraryAccessors extends SubDependencyFactory {

        public AndroidxComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>animation</b> with <b>androidx.compose.animation:animation</b> coordinates and
         * with version reference <b>androidx.compose.latest</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAnimation() {
            return create("androidx.compose.animation");
        }

        /**
         * Dependency provider for <b>bom</b> with <b>androidx.compose:compose-bom</b> coordinates and
         * with version reference <b>composeBom</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getBom() {
            return create("androidx.compose.bom");
        }

        /**
         * Dependency provider for <b>runtime</b> with <b>androidx.compose.runtime:runtime</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRuntime() {
            return create("androidx.compose.runtime");
        }

    }

    public static class AndroidxConstraintlayoutLibraryAccessors extends SubDependencyFactory {

        public AndroidxConstraintlayoutLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.constraintlayout:constraintlayout-compose</b> coordinates and
         * with version reference <b>androidx.constraintlayout</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("androidx.constraintlayout.compose");
        }

    }

    public static class AndroidxEspressoLibraryAccessors extends SubDependencyFactory {

        public AndroidxEspressoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>androidx.test.espresso:espresso-core</b> coordinates and
         * with version reference <b>espressoCore</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("androidx.espresso.core");
        }

    }

    public static class AndroidxNavigationLibraryAccessors extends SubDependencyFactory {
        private final AndroidxNavigationUiLibraryAccessors laccForAndroidxNavigationUiLibraryAccessors = new AndroidxNavigationUiLibraryAccessors(owner);

        public AndroidxNavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.navigation:navigation-compose</b> coordinates and
         * with version reference <b>androidx.navigation</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("androidx.navigation.compose");
        }

        /**
         * Dependency provider for <b>fragment</b> with <b>androidx.navigation:navigation-fragment-ktx</b> coordinates and
         * with version reference <b>androidx.navigation</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFragment() {
            return create("androidx.navigation.fragment");
        }

        /**
         * Group of libraries at <b>androidx.navigation.ui</b>
         */
        public AndroidxNavigationUiLibraryAccessors getUi() {
            return laccForAndroidxNavigationUiLibraryAccessors;
        }

    }

    public static class AndroidxNavigationUiLibraryAccessors extends SubDependencyFactory {

        public AndroidxNavigationUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.navigation:navigation-ui-ktx</b> coordinates and
         * with version reference <b>androidx.navigation</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("androidx.navigation.ui.ktx");
        }

    }

    public static class AndroidxUiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final AndroidxUiTestLibraryAccessors laccForAndroidxUiTestLibraryAccessors = new AndroidxUiTestLibraryAccessors(owner);
        private final AndroidxUiToolingLibraryAccessors laccForAndroidxUiToolingLibraryAccessors = new AndroidxUiToolingLibraryAccessors(owner);

        public AndroidxUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ui</b> with <b>androidx.compose.ui:ui</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.ui");
        }

        /**
         * Dependency provider for <b>graphics</b> with <b>androidx.compose.ui:ui-graphics</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGraphics() {
            return create("androidx.ui.graphics");
        }

        /**
         * Group of libraries at <b>androidx.ui.test</b>
         */
        public AndroidxUiTestLibraryAccessors getTest() {
            return laccForAndroidxUiTestLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.ui.tooling</b>
         */
        public AndroidxUiToolingLibraryAccessors getTooling() {
            return laccForAndroidxUiToolingLibraryAccessors;
        }

    }

    public static class AndroidxUiTestLibraryAccessors extends SubDependencyFactory {

        public AndroidxUiTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit4</b> with <b>androidx.compose.ui:ui-test-junit4</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit4() {
            return create("androidx.ui.test.junit4");
        }

        /**
         * Dependency provider for <b>manifest</b> with <b>androidx.compose.ui:ui-test-manifest</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getManifest() {
            return create("androidx.ui.test.manifest");
        }

    }

    public static class AndroidxUiToolingLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxUiToolingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>tooling</b> with <b>androidx.compose.ui:ui-tooling</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.ui.tooling");
        }

        /**
         * Dependency provider for <b>preview</b> with <b>androidx.compose.ui:ui-tooling-preview</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPreview() {
            return create("androidx.ui.tooling.preview");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final AndroidxVersionAccessors vaccForAndroidxVersionAccessors = new AndroidxVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>achart</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAchart() { return getVersion("achart"); }

        /**
         * Version alias <b>activityCompose</b> with value <b>1.9.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getActivityCompose() { return getVersion("activityCompose"); }

        /**
         * Version alias <b>adapterhelper</b> with value <b>4.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAdapterhelper() { return getVersion("adapterhelper"); }

        /**
         * Version alias <b>agp</b> with value <b>8.5.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAgp() { return getVersion("agp"); }

        /**
         * Version alias <b>ander</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAnder() { return getVersion("ander"); }

        /**
         * Version alias <b>annotation</b> with value <b>1.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAnnotation() { return getVersion("annotation"); }

        /**
         * Version alias <b>appCompat</b> with value <b>1.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAppCompat() { return getVersion("appCompat"); }

        /**
         * Version alias <b>appUpdate</b> with value <b>v1.0.9</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAppUpdate() { return getVersion("appUpdate"); }

        /**
         * Version alias <b>batterytimeline</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBatterytimeline() { return getVersion("batterytimeline"); }

        /**
         * Version alias <b>bleLib</b> with value <b>v1.9.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBleLib() { return getVersion("bleLib"); }

        /**
         * Version alias <b>blechart</b> with value <b>v1.0.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBlechart() { return getVersion("blechart"); }

        /**
         * Version alias <b>blechartv2</b> with value <b>v1.0.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBlechartv2() { return getVersion("blechartv2"); }

        /**
         * Version alias <b>blecompass</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBlecompass() { return getVersion("blecompass"); }

        /**
         * Version alias <b>blev3</b> with value <b>v1.1.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBlev3() { return getVersion("blev3"); }

        /**
         * Version alias <b>cameraX2</b> with value <b>1.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCameraX2() { return getVersion("cameraX2"); }

        /**
         * Version alias <b>cameraXCore</b> with value <b>1.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCameraXCore() { return getVersion("cameraXCore"); }

        /**
         * Version alias <b>cameraXLifeCycle</b> with value <b>1.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCameraXLifeCycle() { return getVersion("cameraXLifeCycle"); }

        /**
         * Version alias <b>cameraXView</b> with value <b>1.0.0-alpha25</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCameraXView() { return getVersion("cameraXView"); }

        /**
         * Version alias <b>cardview</b> with value <b>1.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCardview() { return getVersion("cardview"); }

        /**
         * Version alias <b>colorpicker</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getColorpicker() { return getVersion("colorpicker"); }

        /**
         * Version alias <b>composeBom</b> with value <b>2024.04.01</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getComposeBom() { return getVersion("composeBom"); }

        /**
         * Version alias <b>constraintlayout</b> with value <b>1.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getConstraintlayout() { return getVersion("constraintlayout"); }

        /**
         * Version alias <b>coordinatorlayout</b> with value <b>1.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCoordinatorlayout() { return getVersion("coordinatorlayout"); }

        /**
         * Version alias <b>core</b> with value <b>1.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("core"); }

        /**
         * Version alias <b>coreKtx</b> with value <b>1.8.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCoreKtx() { return getVersion("coreKtx"); }

        /**
         * Version alias <b>cube</b> with value <b>1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCube() { return getVersion("cube"); }

        /**
         * Version alias <b>daolib</b> with value <b>v1.0.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDaolib() { return getVersion("daolib"); }

        /**
         * Version alias <b>dimenx2</b> with value <b>v1.0.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDimenx2() { return getVersion("dimenx2"); }

        /**
         * Version alias <b>dimenx3</b> with value <b>v1.0.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDimenx3() { return getVersion("dimenx3"); }

        /**
         * Version alias <b>druidbanner</b> with value <b>v1.0.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDruidbanner() { return getVersion("druidbanner"); }

        /**
         * Version alias <b>druidhttp</b> with value <b>v1.2.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDruidhttp() { return getVersion("druidhttp"); }

        /**
         * Version alias <b>druidzxing</b> with value <b>v1.0.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDruidzxing() { return getVersion("druidzxing"); }

        /**
         * Version alias <b>dynamicAnimationsKtx</b> with value <b>1.0.0-alpha03</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDynamicAnimationsKtx() { return getVersion("dynamicAnimationsKtx"); }

        /**
         * Version alias <b>espressoCore</b> with value <b>3.6.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getEspressoCore() { return getVersion("espressoCore"); }

        /**
         * Version alias <b>exifinterface</b> with value <b>1.3.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getExifinterface() { return getVersion("exifinterface"); }

        /**
         * Version alias <b>fastjson</b> with value <b>1.2.8</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getFastjson() { return getVersion("fastjson"); }

        /**
         * Version alias <b>foldermanager</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getFoldermanager() { return getVersion("foldermanager"); }

        /**
         * Version alias <b>fragmentKtx</b> with value <b>1.3.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getFragmentKtx() { return getVersion("fragmentKtx"); }

        /**
         * Version alias <b>freshView</b> with value <b>v1.0.6</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getFreshView() { return getVersion("freshView"); }

        /**
         * Version alias <b>gifImage</b> with value <b>1.2.27</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGifImage() { return getVersion("gifImage"); }

        /**
         * Version alias <b>glide</b> with value <b>4.11.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGlide() { return getVersion("glide"); }

        /**
         * Version alias <b>googleLocation</b> with value <b>18.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGoogleLocation() { return getVersion("googleLocation"); }

        /**
         * Version alias <b>googleMap</b> with value <b>18.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGoogleMap() { return getVersion("googleMap"); }

        /**
         * Version alias <b>gpslocation</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGpslocation() { return getVersion("gpslocation"); }

        /**
         * Version alias <b>greendao</b> with value <b>3.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGreendao() { return getVersion("greendao"); }

        /**
         * Version alias <b>greendaohelper</b> with value <b>v2.2.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGreendaohelper() { return getVersion("greendaohelper"); }

        /**
         * Version alias <b>gson</b> with value <b>2.7</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGson() { return getVersion("gson"); }

        /**
         * Version alias <b>imageloader</b> with value <b>1.9.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getImageloader() { return getVersion("imageloader"); }

        /**
         * Version alias <b>imageviewer</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getImageviewer() { return getVersion("imageviewer"); }

        /**
         * Version alias <b>interpolator</b> with value <b>1.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getInterpolator() { return getVersion("interpolator"); }

        /**
         * Version alias <b>jiaozivideoplayer</b> with value <b>6.2.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJiaozivideoplayer() { return getVersion("jiaozivideoplayer"); }

        /**
         * Version alias <b>junit</b> with value <b>4.13.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunit() { return getVersion("junit"); }

        /**
         * Version alias <b>junitVersion</b> with value <b>1.2.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunitVersion() { return getVersion("junitVersion"); }

        /**
         * Version alias <b>kotlin</b> with value <b>2.0.20</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotlin() { return getVersion("kotlin"); }

        /**
         * Version alias <b>ktlib</b> with value <b>v1.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKtlib() { return getVersion("ktlib"); }

        /**
         * Version alias <b>leaks</b> with value <b>2.12</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLeaks() { return getVersion("leaks"); }

        /**
         * Version alias <b>lifecycleCommonJava8</b> with value <b>2.6.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLifecycleCommonJava8() { return getVersion("lifecycleCommonJava8"); }

        /**
         * Version alias <b>lifecycleExtensions</b> with value <b>2.2.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLifecycleExtensions() { return getVersion("lifecycleExtensions"); }

        /**
         * Version alias <b>lifecycleLiveDataKtx</b> with value <b>2.6.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLifecycleLiveDataKtx() { return getVersion("lifecycleLiveDataKtx"); }

        /**
         * Version alias <b>lifecycleReactivestreams</b> with value <b>2.3.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLifecycleReactivestreams() { return getVersion("lifecycleReactivestreams"); }

        /**
         * Version alias <b>lifecycleRuntimeKtx</b> with value <b>2.6.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLifecycleRuntimeKtx() { return getVersion("lifecycleRuntimeKtx"); }

        /**
         * Version alias <b>lifecycleViewmodelKtx</b> with value <b>2.6.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLifecycleViewmodelKtx() { return getVersion("lifecycleViewmodelKtx"); }

        /**
         * Version alias <b>liveDataUnpeek</b> with value <b>4.4.1-beta1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLiveDataUnpeek() { return getVersion("liveDataUnpeek"); }

        /**
         * Version alias <b>loadsir</b> with value <b>1.3.8</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLoadsir() { return getVersion("loadsir"); }

        /**
         * Version alias <b>locallan</b> with value <b>v1.0.9</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLocallan() { return getVersion("locallan"); }

        /**
         * Version alias <b>locationtech</b> with value <b>1.17.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLocationtech() { return getVersion("locationtech"); }

        /**
         * Version alias <b>mapboxBase</b> with value <b>0.11.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMapboxBase() { return getVersion("mapboxBase"); }

        /**
         * Version alias <b>mapboxGestures</b> with value <b>0.8.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMapboxGestures() { return getVersion("mapboxGestures"); }

        /**
         * Version alias <b>mapboxJavaServices</b> with value <b>5.4.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMapboxJavaServices() { return getVersion("mapboxJavaServices"); }

        /**
         * Version alias <b>mapboxLocation</b> with value <b>0.12.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMapboxLocation() { return getVersion("mapboxLocation"); }

        /**
         * Version alias <b>mapboxPluginAnnotation</b> with value <b>0.9.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMapboxPluginAnnotation() { return getVersion("mapboxPluginAnnotation"); }

        /**
         * Version alias <b>mapboxPluginMarkerView</b> with value <b>0.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMapboxPluginMarkerView() { return getVersion("mapboxPluginMarkerView"); }

        /**
         * Version alias <b>mapboxSdxV10</b> with value <b>10.13.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMapboxSdxV10() { return getVersion("mapboxSdxV10"); }

        /**
         * Version alias <b>mapboxSdxV9</b> with value <b>9.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMapboxSdxV9() { return getVersion("mapboxSdxV9"); }

        /**
         * Version alias <b>mapboxTurf</b> with value <b>5.4.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMapboxTurf() { return getVersion("mapboxTurf"); }

        /**
         * Version alias <b>mapboxV11</b> with value <b>11.7.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMapboxV11() { return getVersion("mapboxV11"); }

        /**
         * Version alias <b>mapview</b> with value <b>v2.5.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMapview() { return getVersion("mapview"); }

        /**
         * Version alias <b>material</b> with value <b>1.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMaterial() { return getVersion("material"); }

        /**
         * Version alias <b>mp4parser</b> with value <b>1.1.21</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMp4parser() { return getVersion("mp4parser"); }

        /**
         * Version alias <b>mpchart</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMpchart() { return getVersion("mpchart"); }

        /**
         * Version alias <b>navigationFragment</b> with value <b>2.7.7</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNavigationFragment() { return getVersion("navigationFragment"); }

        /**
         * Version alias <b>navigationUiKtx</b> with value <b>2.3.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNavigationUiKtx() { return getVersion("navigationUiKtx"); }

        /**
         * Version alias <b>navigator</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNavigator() { return getVersion("navigator"); }

        /**
         * Version alias <b>nineoldandroids</b> with value <b>2.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNineoldandroids() { return getVersion("nineoldandroids"); }

        /**
         * Version alias <b>nohttp</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNohttp() { return getVersion("nohttp"); }

        /**
         * Version alias <b>okhttp3</b> with value <b>4.12.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getOkhttp3() { return getVersion("okhttp3"); }

        /**
         * Version alias <b>okhttp3Connection</b> with value <b>3.14.9</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getOkhttp3Connection() { return getVersion("okhttp3Connection"); }

        /**
         * Version alias <b>okhttp3Interagtion</b> with value <b>4.9.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getOkhttp3Interagtion() { return getVersion("okhttp3Interagtion"); }

        /**
         * Version alias <b>persistentCookieJar</b> with value <b>v1.0.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPersistentCookieJar() { return getVersion("persistentCookieJar"); }

        /**
         * Version alias <b>photoview</b> with value <b>2.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPhotoview() { return getVersion("photoview"); }

        /**
         * Version alias <b>picasso</b> with value <b>2.3.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPicasso() { return getVersion("picasso"); }

        /**
         * Version alias <b>pickerview</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPickerview() { return getVersion("pickerview"); }

        /**
         * Version alias <b>protobuf</b> with value <b>3.7.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getProtobuf() { return getVersion("protobuf"); }

        /**
         * Version alias <b>qrcodeLib</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getQrcodeLib() { return getVersion("qrcodeLib"); }

        /**
         * Version alias <b>recyclerview</b> with value <b>1.2.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRecyclerview() { return getVersion("recyclerview"); }

        /**
         * Version alias <b>retrofit2</b> with value <b>2.11.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRetrofit2() { return getVersion("retrofit2"); }

        /**
         * Version alias <b>retrofit2Gson</b> with value <b>2.11.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRetrofit2Gson() { return getVersion("retrofit2Gson"); }

        /**
         * Version alias <b>retrofitUrlManager</b> with value <b>1.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRetrofitUrlManager() { return getVersion("retrofitUrlManager"); }

        /**
         * Version alias <b>router</b> with value <b>v1.0.7</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRouter() { return getVersion("router"); }

        /**
         * Version alias <b>rxandroid</b> with value <b>2.1.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRxandroid() { return getVersion("rxandroid"); }

        /**
         * Version alias <b>rxjava</b> with value <b>2.2.21</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRxjava() { return getVersion("rxjava"); }

        /**
         * Version alias <b>rxkotlin</b> with value <b>2.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRxkotlin() { return getVersion("rxkotlin"); }

        /**
         * Version alias <b>scaleimageview</b> with value <b>3.10.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getScaleimageview() { return getVersion("scaleimageview"); }

        /**
         * Version alias <b>scrolltable</b> with value <b>v1.0.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getScrolltable() { return getVersion("scrolltable"); }

        /**
         * Version alias <b>sdcard</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSdcard() { return getVersion("sdcard"); }

        /**
         * Version alias <b>shimmerlayout</b> with value <b>2.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getShimmerlayout() { return getVersion("shimmerlayout"); }

        /**
         * Version alias <b>signseekbar</b> with value <b>1.0.6</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSignseekbar() { return getVersion("signseekbar"); }

        /**
         * Version alias <b>skeleton</b> with value <b>1.1.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSkeleton() { return getVersion("skeleton"); }

        /**
         * Version alias <b>smartfeshv2</b> with value <b>v1.1.9</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSmartfeshv2() { return getVersion("smartfeshv2"); }

        /**
         * Version alias <b>snackbar</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSnackbar() { return getVersion("snackbar"); }

        /**
         * Version alias <b>socket</b> with value <b>v1.0.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSocket() { return getVersion("socket"); }

        /**
         * Version alias <b>sqlitektx</b> with value <b>2.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSqlitektx() { return getVersion("sqlitektx"); }

        /**
         * Version alias <b>styletheme</b> with value <b>v1.0.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getStyletheme() { return getVersion("styletheme"); }

        /**
         * Version alias <b>swiperefreshlayout</b> with value <b>1.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSwiperefreshlayout() { return getVersion("swiperefreshlayout"); }

        /**
         * Version alias <b>table</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTable() { return getVersion("table"); }

        /**
         * Version alias <b>tencentlocation</b> with value <b>7.5.4.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTencentlocation() { return getVersion("tencentlocation"); }

        /**
         * Version alias <b>timebarLib</b> with value <b>v1.0.8</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTimebarLib() { return getVersion("timebarLib"); }

        /**
         * Version alias <b>tts</b> with value <b>v1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTts() { return getVersion("tts"); }

        /**
         * Version alias <b>viewguid</b> with value <b>v1.0.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getViewguid() { return getVersion("viewguid"); }

        /**
         * Version alias <b>viewpager</b> with value <b>1.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getViewpager() { return getVersion("viewpager"); }

        /**
         * Version alias <b>viewpager2</b> with value <b>1.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getViewpager2() { return getVersion("viewpager2"); }

        /**
         * Version alias <b>wcdb</b> with value <b>2.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getWcdb() { return getVersion("wcdb"); }

        /**
         * Version alias <b>widget</b> with value <b>v1.0.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getWidget() { return getVersion("widget"); }

        /**
         * Version alias <b>zxing</b> with value <b>3.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getZxing() { return getVersion("zxing"); }

        /**
         * Group of versions at <b>versions.androidx</b>
         */
        public AndroidxVersionAccessors getAndroidx() {
            return vaccForAndroidxVersionAccessors;
        }

    }

    public static class AndroidxVersionAccessors extends VersionFactory  {

        private final AndroidxComposeVersionAccessors vaccForAndroidxComposeVersionAccessors = new AndroidxComposeVersionAccessors(providers, config);
        public AndroidxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>androidx.constraintlayout</b> with value <b>1.1.0-alpha13</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getConstraintlayout() { return getVersion("androidx.constraintlayout"); }

        /**
         * Version alias <b>androidx.navigation</b> with value <b>2.7.7</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNavigation() { return getVersion("androidx.navigation"); }

        /**
         * Group of versions at <b>versions.androidx.compose</b>
         */
        public AndroidxComposeVersionAccessors getCompose() {
            return vaccForAndroidxComposeVersionAccessors;
        }

    }

    public static class AndroidxComposeVersionAccessors extends VersionFactory  {

        public AndroidxComposeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>androidx.compose.latest</b> with value <b>1.7.0-beta07</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLatest() { return getVersion("androidx.compose.latest"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {
        private final AndroidPluginAccessors paccForAndroidPluginAccessors = new AndroidPluginAccessors(providers, config);
        private final ComposePluginAccessors paccForComposePluginAccessors = new ComposePluginAccessors(providers, config);
        private final JetbrainsPluginAccessors paccForJetbrainsPluginAccessors = new JetbrainsPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.android</b>
         */
        public AndroidPluginAccessors getAndroid() {
            return paccForAndroidPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.compose</b>
         */
        public ComposePluginAccessors getCompose() {
            return paccForComposePluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.jetbrains</b>
         */
        public JetbrainsPluginAccessors getJetbrains() {
            return paccForJetbrainsPluginAccessors;
        }

    }

    public static class AndroidPluginAccessors extends PluginFactory {

        public AndroidPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>android.application</b> with plugin id <b>com.android.application</b> and
         * with version reference <b>agp</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getApplication() { return createPlugin("android.application"); }

        /**
         * Plugin provider for <b>android.library</b> with plugin id <b>com.android.library</b> and
         * with version reference <b>agp</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getLibrary() { return createPlugin("android.library"); }

    }

    public static class ComposePluginAccessors extends PluginFactory {

        public ComposePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>compose.compiler</b> with plugin id <b>org.jetbrains.kotlin.plugin.compose</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getCompiler() { return createPlugin("compose.compiler"); }

    }

    public static class JetbrainsPluginAccessors extends PluginFactory {
        private final JetbrainsKotlinPluginAccessors paccForJetbrainsKotlinPluginAccessors = new JetbrainsKotlinPluginAccessors(providers, config);

        public JetbrainsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.jetbrains.kotlin</b>
         */
        public JetbrainsKotlinPluginAccessors getKotlin() {
            return paccForJetbrainsKotlinPluginAccessors;
        }

    }

    public static class JetbrainsKotlinPluginAccessors extends PluginFactory {

        public JetbrainsKotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>jetbrains.kotlin.android</b> with plugin id <b>org.jetbrains.kotlin.android</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getAndroid() { return createPlugin("jetbrains.kotlin.android"); }

    }

}
