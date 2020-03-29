public class SimplifiedArithmeticPart1 {
    public String findSimpleGene(String dna){
        int startindex=dna.indexOf("ATG");
        if(startindex==-1){
            return  "";
        }
        int stopindex=dna.indexOf("TAA");
        if(stopindex==-1){
            return "";
        }
        String sub=dna.substring(startindex,stopindex+3);
        if(sub.length()%3==0){
            return sub;
        }
        else{
            return "";
        }
    }
    public void testSimpleGene(){
        String dna1="AAAATAMGNABETAA";
        String dna2="ATGBDSHAITRSNDFKHFUIWBDFIWSHDNSMFHIERNMSFIERHNSMFNIEFHFF";
        String dna3="sdfhsfbgjfbbfsjgiwhiiehirhifgkbxvbsfjkbgvkfg";
        String dna4="ATG123456789TAA";
        String dna5="ATG12345678TAA";
        System.out.println("DNA 1 "+findSimpleGene(dna1));

        System.out.println("DNA 1 "+findSimpleGene(dna2));
        System.out.println("DNA 1 "+findSimpleGene(dna3));
        System.out.println("DNA 1 "+findSimpleGene(dna4));
        System.out.println("DNA 1 "+findSimpleGene(dna5));
        //System.out.print("DNA 1"+findSimpleGene(dna1));


    }
    public static  void main(String[] args){
        SimplifiedArithmeticPart1 sa=new SimplifiedArithmeticPart1();
        sa.testSimpleGene();
    }
}
