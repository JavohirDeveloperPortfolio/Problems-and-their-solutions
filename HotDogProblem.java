public class HotDogProblem {
    public static void main(String[] args) {
        String file1 = "input1.txt";
        String file2 = "input2.txt";
        String res = "output.txt";
        String[] nums = read(file1).split(",");
        int x = Integer.parseInt(nums[0]);
        int y = Integer.parseInt(nums[1]);

        String[] nums2 = read(file2).split(" ");

        int i = 0;
        for (String s : nums2) {
            int num = Integer.parseInt(s);
            if (num % x == 0 && num % y == 0){
                write(res,"HotDog");
            }
            else if (num % x == 0){
                write(res, "Hot");
            }
            else if (num % y == 0){
                write(res, "Dog");
            }
            else {
                write(res,s);
            }

            if (i != nums2.length-1){
                write(res," ");
            }
            i++;
        }
    }

    public static String read(String fileUrl){
        String res = "";
        try (java.io.FileReader fileReader = new java.io.FileReader(fileUrl)) {
            int c;
            while ((c = fileReader.read())!=-1){
                res += (char) c;
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void write(String fileUrl, String text){
        try (java.io.FileWriter fileWriter = new java.io.FileWriter(fileUrl, true)) {
            fileWriter.write(text);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
