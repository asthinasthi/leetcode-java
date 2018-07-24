import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CreateSQL {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("C:\\dx10\\dx10.txt"));
		String currLine;
		
		while ((currLine = br.readLine()) != null) {
//			System.out.println(currLine);
			String[] strings = currLine.split(";");
			String SQL = "INSERT INTO dx_codes values ('"+strings[0]+"', '"+strings[1]+"', 'Afirma', 'ICD-10');";
			System.out.println(SQL);
		}
	}

}
