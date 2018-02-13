/* genTrainingSet generates a DNA training set and performs subsequent
 * pattern matches against a modifiable consensus query as indicated below.
 * An additional query specifies the "ATG" start codon and searches for it within 
 * the initial matches.  Simple as that.
 * Christopher McFall 03/14/16
 */

import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DNAMotifFinder {
	public static void main(String[] args) throws IOException {
		
		File file = new File("/home/dashing/Desktop/file.txt"); //INPUT FILE PATH!
		FileWriter fileWriter = new FileWriter(file);
		
		for (int i = 0; i < 3000; i++) { //generate 3000 DNA training sequences
			
			char[] chars = "ATGC".toCharArray();
				
				StringBuilder sb = new StringBuilder();
				Random random = new Random();
		
					for (int ii = 0; ii < 500; ii++) { //test sequence lengths = 500 nucleotides each
						char c = chars[random.nextInt(chars.length)];
						sb.append(c);
					}

					String output = sb.toString();
			
					fileWriter.write(">Test DNA " + "[" + (i + 1) + "]\n");
					fileWriter.write(output + "\n\n");
			}
			fileWriter.flush();
			fileWriter.close();
			
				DNAMotifFinderClass CClassObject1 = new DNAMotifFinderClass(); 
				CClassObject1.getDNAMotif();  // call getDNAMotif() method contained within class genTrainingSetclass
		
		}
	}