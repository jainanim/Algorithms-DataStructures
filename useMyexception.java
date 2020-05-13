public class useMyexception {

    public static void main(String[] args) {

            try {
                throw new myException("animaa","garima");
            } catch (myException e) {
                //e.getMessage();
                //e.getErrorCode();
                e.printStackTrace();
            }




    }
}
