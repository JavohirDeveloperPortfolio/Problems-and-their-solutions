public class RewriteString {
    public static void main(String[] args) {

        java.io.File file1 = new java.io.File("input.txt");
        java.io.File file2 = new java.io.File("output.txt");
        java.io.File file3 = new java.io.File("output2.txt");
        try {
            boolean createFile1 = file1.createNewFile();
            boolean createFile2 = file2.createNewFile();
            boolean createFile3 = file3.createNewFile();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        String str = read(file1);

        writeToFile(file2, removeMaxChar(str));

        writeToFile(file3, sorting(str));
    }

    public static void writeToFile(java.io.File file, String str){
        try (java.io.FileWriter fileWriter = new java.io.FileWriter(file, false)) {
            fileWriter.write((str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String read(java.io.File file) {
        StringBuilder result = new StringBuilder();
        try (java.io.FileReader fileReader = new java.io.FileReader(file)) {
            int c;
            while ((c = fileReader.read()) != -1) {
                result.append((char) c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static String removeMaxChar(String output) {
        String str = output;
        int[] alpha = new int[26];
        for (char c : output.toCharArray()) {
            alpha[c - 97]++;
        }

        int max = Integer.MIN_VALUE;
        for (int i=0; i<26; i++) {
            if (alpha[i] > max) {
                max = alpha[i];
            }
        }

        for (int i=0; i<26; i++) {
            if (alpha[i] == max) {
                output = output.replaceAll(String.valueOf((char) (i + 97)), "");
            }
        }
        if (output.equals("")) return str;
        return output;
    }

    public static String sorting(String str) {
        int[] alpha = new int[26];
        for (char c : str.toCharArray()) {
            alpha[c - 97]++;
        }

        int[][] arr = new int[26][2];
        for (int i=0; i<26; i++) {
            arr[i][0] = i;
            arr[i][1] = alpha[i];
        }

        java.util.Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            else return b[1] - a[1];
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<26; i++) {
            if (arr[i][1] != 0) {
                stringBuilder.append((char) (arr[i][0] + 97)).append(":").append(arr[i][1]).append(" ");
            }
        }
        return stringBuilder.toString();
    }

}