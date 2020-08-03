
package kr.co.digigroove.qrboard_tool.constant;

public class Default {

    /** Result */
    public static final class Result {
        public static final String SUCCESS      = "Success";
        public static final String FAIL         = "Fail";
        public static final String MISMATCH     = "Mismatch";
        public static final String EMPTY_USER   = "EmptyUser";
        public static final String NOT_APPROVE  = "NotApprove";
        public static final String WITHDRAW     = "Withdraw";
    }

    public static final class UserGrade {
        public static final int ADMIN               = 1;
        public static final int ADVERTISER_ADMIN    = 2;
        public static final int ADVERTISER          = 3;
    }

    public static final class UserType {
        public static final int FREE_MEMBER    = 0;
        public static final int PAID_MEMBER    = 1;
    }

    public static final class UserState {
        public static final int WAIT        = 0;
        public static final int APPROVE     = 1;
        public static final int WITHDRAW    = 2;
    }

}
