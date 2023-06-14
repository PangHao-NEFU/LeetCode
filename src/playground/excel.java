public class excel {
    public String convertToTitle (int columnNumber) {
        // write code here
        StringBuilder result = new StringBuilder();

        while (columnNumber>0){
            columnNumber--;
            int rm = columnNumber % 26;
            char columnChar = (char) ('A' + rm);
            result.insert(0, columnChar);
            columnNumber /= 26;
        }
        return result


    }
}
