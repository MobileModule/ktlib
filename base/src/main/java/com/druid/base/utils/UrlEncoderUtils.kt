package com.druid.base.utils


class UrlEncoderUtils private constructor() {
    companion object {
        @JvmStatic
        fun hasUrlEncoded(str: String): Boolean {
            var encode = false
            for (i in str.indices) {
                val c = str[i]
                if (c == '%' && i + 2 < str.length) {
                    // 判断是否符合urlEncode规范
                    val c1 = str[i + 1]
                    val c2 = str[i + 2]
                    if (isValidHexChar(c1) && isValidHexChar(c2)) {
                        encode = true
                        break
                    } else {
                        break
                    }
                }
            }
            return encode
        }

        /**
         * 判断 c 是否是 16 进制的字符
         *
         * @param c 需要判断的字符
         * @return 返回 `true` 为 16 进制的字符
         */
        private fun isValidHexChar(c: Char): Boolean {
            return c in '0'..'9' || c in 'a'..'f' || c in 'A'..'F'
        }
    }

    init {
        throw IllegalStateException("you can't instantiate me!")
    }
}