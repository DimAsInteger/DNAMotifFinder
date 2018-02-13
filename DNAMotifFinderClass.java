import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class DNAMotifFinderClass {
	public static DecimalFormat dec2 = new DecimalFormat("#.##");
	public void getDNAMotif() {
		
			try {
					File allOfThisGibberishJustToGetAFile = new File("/home/dashing/Desktop/file.txt");  //INPUT FILE PATH!
					FileReader verboseAsUsual = new FileReader(allOfThisGibberishJustToGetAFile);
					BufferedReader blahBlahblahBlah = new BufferedReader(verboseAsUsual);

						ArrayList<String> aar = new ArrayList<String>();
	       		
						String WhatAMess;
	       	        	
	       				while ((WhatAMess = blahBlahblahBlah.readLine()) != null) {
	                            aar.add(WhatAMess);
	       	               }
	       						
	       				blahBlahblahBlah.close();
  
	       					String goodHeader = ""; 
	       					
	       						for (String everyoneLovesGoodHeader : aar) {
	       							goodHeader += everyoneLovesGoodHeader + "\n";
	       						}

	       						int x = goodHeader.indexOf(">"); //set header
	       						int y = goodHeader.indexOf("]"); //set sequence
	       						y++;
	       						int z = goodHeader.indexOf("]"); z++; //set first sequence
	       						int xy = goodHeader.indexOf(">", z++); //set first header
                     
	       						do {
	       							String divheader = goodHeader.substring(x, y);  //print headers
	       								x = goodHeader.indexOf(">", y);
	       								y = goodHeader.indexOf("]", x);
	       								y++;    
                         
	       							String nucleotideSequences = goodHeader.substring( z, xy ); //print sequences
	       								z = goodHeader.indexOf("]", z);
	       								xy = goodHeader.indexOf(">", z++);

	       								Pattern p = Pattern.compile("[A].{1}[T].{2}[A].{5}[C].{6}[G].{8}[T].{1}[G].{16}[G].{200}[T]"); //test regex consensus sequence: A-x1-T-x2-A-x5-C-x6-G-x8-T-x1-G-x16-G-x200-T
	       								Matcher m = p.matcher("");
	       								m.reset(nucleotideSequences);

	       									if (m.find()) {

	       											for (int i = 0; i <= 0; i++) {
	       													
	       													System.out.print(divheader); //print out matching header
	       													System.out.print("\nDNA MOTIF SEQUENCE FOUND: \n" + m.group()); //lists site according to pattern match
	       													System.out.print("\nRegions: " + m.start() + " - " + m.end());
	       													System.out.print("\nSequence Length: " + m.group().length());
	       													System.out.print("\nFound Within DNA Test Sequence: " + nucleotideSequences);  //prints out all nucleotide sequences containing match

	       												}
	       											
	       														Pattern pat = Pattern.compile("ATG"); //start codon regex consensus sequence (ATG)
	       														Matcher mat = pat.matcher("");
	       														mat.reset(m.group());
				       								
	       				       									if (mat.find()) {
	    			       											
	    			       											StringBuilder nucscanner = new StringBuilder();
	    			       		       								
    			       		       							        	nucscanner.append(m.group());
    			       		       							      
    			       		       							        		String pukeItUp = nucscanner.toString();
    			       		       							    
    			       		       							        			char [] dnascanner = pukeItUp.toCharArray();
    			       		       							 
    			       		       							        			forscanner: for (int input = 0; input < dnascanner.length; input++) {
    			       		       									
    			       		       							        				switch (dnascanner[input]) {
    			       		       							        					case 'T': dnascanner[input] = 'A';
    			       		       							        				break;
    			       		       							        					case 'G': dnascanner[input] = 'C';
    			       		       							        				break;
    			       		       							        					case 'A': dnascanner[input] = 'T';
    			       		       							        				break;
    			       		       							        					case 'C': dnascanner[input] = 'G';
    			       		       							        				break;
    			       		       							        					default:

    			       		       							        					break forscanner;
    			       		       							        				}
    			       		       							        			}
    			       		       							        		
    			       		       							        		String anotherDrinkOnme = String.valueOf(dnascanner);
    			       		       							        		
    			       		       							        		Map < Character, Integer > baseMap = new HashMap < Character, Integer > ();

    			       		       							        			for (int i = 0; i <= 0; i++) {
    			       		       							        				
    	    			       			       										for(char nt:dnascanner) {
    	    			       			       								    	    if (baseMap.containsKey(nt)) {
    	    			       			       								    	        int ntCount = baseMap.get(nt);
    	    			       			       								    	        baseMap.put(nt, ntCount + 1);
    	    			       			       								    	    }
    	    			       			       								    	    else {
    	    			       			       								    	        baseMap.put(nt, 1);
    	    			       			       								    	    }
    	    			       			       								    	}

    	    			       			       								     float charCount = baseMap.get('A') + baseMap.get('T') + baseMap.get('G') + baseMap.get('C');
    	    			       			       							    	 float GC = baseMap.get('G') + baseMap.get('C');
    	    			       			       							    	 float GCfig = GC/charCount;
    	    			       			       							    	 float percentGC = GCfig * 100; 

    			       		       							        					System.out.print("***" + divheader + "***START CODON FOUND!*** " + mat.group()); //lists site according to pattern match
    			       		       							        					System.out.print("\nRegions: " + mat.start() + " - " + mat.end());
    			       		       							        					System.out.print("\nQuery Sequence: " + m.group());  //prints out all nucleotide sequences containing match
    			       		       							        				    System.out.print("\nReverse Complement: " + anotherDrinkOnme);
    	    	    			       			       							    	System.out.println("\nQuery Sequence GC Content: " + GC);
    	    	    			       			       							    	System.out.println("\n% GC Content: " + dec2.format(percentGC));
    	    	    			       			       							    	System.out.print("\nTotal Number of Characters Counted " + charCount + "\n");
    	    	    			       			       							    	 
    	    	    			       			       							    		System.out.print("\nCharacter Frequencies: \n");
    	    	    			       			       								    	for (char nt : baseMap.keySet()) {
    	    	    			       			       								    	    System.out.print("\n" + nt + " = " + baseMap.get(nt));
    	    	    			       			       								    	}
    	    	    			       			       								    		
    	    	    			       			       								    		
    	    	    			       			       								    	System.out.print("\n\nZero Order Markov Chain Probabilities: \n");
    	    	    			       			       								    	for (char nt : baseMap.keySet()) {
    	    	    			       			       								    		float zeroOrder = nt/charCount;
    	    	    			       			       								    	    System.out.print("\n" + nt + " = " + dec2.format(zeroOrder));
    	    	    			       			       								    	}

    	    	    			       			       								    		System.out.print("\n_______________________________________________________________________________________________________________________");
    	    	    			       			       								    		System.out.print("\n\n");

    			       		       							        			}
	       				       									}
       											}
	       						}
	       						while( xy != -1 );
	      						}
						
                  catch (Exception e){
                    System.out.println("ERROR: CAN'T FIND YOUR FILE!" + e.getMessage()); 
            }
		}
}
