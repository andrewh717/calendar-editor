import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalendarEditor {
    public static void main(String[] args) throws Exception {
        // arg[0] must be the name of the ics file beind edited
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int extensionIndex = args[0].indexOf(".ics");
        String fileName = args[0].substring(0, extensionIndex);
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + "-edited.ics"));

        // Get user input of oringal summary
        System.out.println("Enter the name of the summary you'd like to change: ");
        String originalSummary = input.readLine();

        // Get user input of edited summary
        System.out.println("Enter what you'd like it to be changed to: ");
        String editedSummary = input.readLine();

        System.out.println("... Creating new ICS file with your desired changes ...");
        changeSummary(br, bw, originalSummary, editedSummary);

        bw.close();

        System.out.println("\nDone! Your new ICS file has been created.");

        return;
    }

    public static void changeSummary(BufferedReader br, BufferedWriter bw, String original, String edited) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            if (line.startsWith("SUMMARY:" + original)) {
                bw.write("SUMMARY:" + edited);
                bw.newLine();
                bw.flush();          
            } else {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
        }
    }
}
