public class Slot {
    private String row;
    private Integer column;

    public Slot(String code) {
        row = "NONE";
        column = 0;
        for (int i = 0; i < code.length(); i++) {
            if (i == 0) {
                row = String.valueOf(code.charAt(i));
            } else {
                column = Integer.valueOf(String.valueOf(code.charAt(i)));
            }
        }
    }

    public String getRow() {
        return row;
    }

    public Integer getColumn() {
        return column;
    }
}