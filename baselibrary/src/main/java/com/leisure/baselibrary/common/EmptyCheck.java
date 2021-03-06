package com.leisure.baselibrary.common;

import java.util.Collection;
import java.util.Map;

/**
 * Created by json on 2015/12/1.
 */
public class EmptyCheck {
        public static boolean isEmpty(CharSequence str) {
            return isNull(str) || str.length() == 0;
        }

        public static boolean isEmpty(Object[] os) {
            return isNull(os) || os.length == 0;
        }

        public static boolean isEmpty(Collection<?> l) {
            return isNull(l) || l.isEmpty();
        }

        public static boolean isEmpty(Map<?, ?> m) {
            return isNull(m) || m.isEmpty();
        }

        public static boolean isNull(Object o) {
            return o == null;
        }
}
