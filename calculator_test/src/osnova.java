public enum osnova {
    PL {
        public int action(String x, String y) {
            int op = Integer.parseInt(x)+Integer.parseInt(y);
            return op;
        }},
    UM{
        public int action(String x, String y) {
            int op = Integer.parseInt(x)*Integer.parseInt(y);
            return op;
        }},
    DE{
        public int action(String x, String y) {
            int op = Integer.parseInt(x)/Integer.parseInt(y);
            return op;
        }},
    MI{
        public int action(String x, String y) {
            int op = Integer.parseInt(x)-Integer.parseInt(y);
            return op;
        }};

    public abstract int action(String x, String y);
}