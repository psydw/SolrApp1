import java.util.Scanner;


public class ConsoleSolrTester 
{
	public static void main(String[] args){
		System.out.print("Hello World!");
	       Scanner in;
	       SolrService searching = new SolrService();
	       SolrMasterArtist searchResult;
	       while(true){
	    	   in = new Scanner(System.in);
	    	   searchResult = searching.searchMasterArtist(in.nextLine());
	    	   System.out.println(searchResult.id);
	       }
	       
	}
}

