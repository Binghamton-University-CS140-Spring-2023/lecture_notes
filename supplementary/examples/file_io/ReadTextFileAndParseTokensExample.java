import java.io.BufferedReader;       // importing the necessary classes
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class ReadTextFileAndParseTokensExample {
    public static void main(String[] args) {
        if(args.length != 1) {  // check the command line has a single argument
            System.out.println("format is: ReadTextFileAndParseTokensExample \"input file name\"");
            System.exit(0);
        }

        try    {
            BufferedReader input = new BufferedReader(
          new InputStreamReader(new FileInputStream(args[0])));
            String inn;
            while((inn = input.readLine()) != null) {    // read a line
                StringTokenizer st = new StringTokenizer(inn);  
                System.out.println(inn + " (" + st.countTokens() + ")"); // print it
                while(st.hasMoreTokens()) {    // go through the tokens in the line
                    String s = st.nextToken();
                    System.out.println("\t" + s);
                }
            }
            input.close();
        } catch(Exception e) {  // if any exceptions, write a message
            System.out.println(e.toString());
            System.exit(1);
        }
    }
}
