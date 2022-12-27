package testdata;

public class TestData {
    public static class Data {
        public static String emailValue = "username@domen.com";
        public static String nameValue = "Ivan";
        public static String passwordValue = "Ivan";
        public static String welcomeMessage = "";

        /**
         * defines, if user is signed in. If true - signed in
         */
        public static Boolean isSignedIn = null;

        /**
         * valid values
         */
        public static String[] emailValue1 = {"ivanovivan@mail.ru", "marinapetrova@google.com"};
        public static String[] nameValue1 = {"ivan", ""};
        public static String[] passwordValue1 = {"12345", "ABCD"};

        /**
         * empty values
         */
        public static String emailValue2 = "";
        public static String nameValue2 = "";
        public static String passwordValue2 = "";
        public static String welcomeMessage2 = "";

        /**
         * invalid and empty values
         */
        public static String[] emailValue3 = {"@", "ivanivanov .ru", "", "", "Qqwerty@rs", ""};
        public static String[] nameValue3 = {"    ", "@@@@ЁЖЗ__RRa", "", "Nikolay", "", "John"};
        public static String[] passwordValue3 = {"   ", "1", "12345", "", "", "qwe!@#$%%^"};
        public static String welcomeMessage3 = "";

        /**
         * values for Remember me checkbox testing
         */
        public static String emailValue4 = "arnoldPirozhkov@google.com";
        public static String nameValue4 = "Arni";
        public static String passwordValue4 = "12QW";

        /**
         * values for Welcome message testing
         */
        public static String[] emailValue5 = {"petrovpetr@mail.ru", "sashalutiy@google.com"};
        public static String[] nameValue5 = {"petr", ""};
        public static String[] passwordValue5 = {"321", "bcd"};
    }
}
