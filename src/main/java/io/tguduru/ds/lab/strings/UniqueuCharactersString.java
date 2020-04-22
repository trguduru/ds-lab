package io.tguduru.ds.lab.strings;

/**
 * @author Guduru, Thirupathi Reddy
 * @modified 6/12/16.
 */
public class UniqueuCharactersString {
    public UniqueuCharactersString(String str){
        givenString = str;
    }
    private String givenString;
    public boolean hasUniqueuCharacters(){
        char[] charArray = givenString.toCharArray();
        for(int i = 0 ; i < charArray.length ; i++){
            char ch = charArray[i];
            for(int j = 0 ; j < charArray.length ; j ++){
                if(ch == charArray[j] && i != j){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        UniqueuCharactersString charactersString = new UniqueuCharactersString("DUP");
        System.out.println(charactersString.hasUniqueuCharacters());

        //some bit shift to right
        System.out.println(8>>1);
        System.out.println(8<<1);
    }
}
