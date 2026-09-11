package codingTest.exhaustiveSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다. 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.

단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.

제한사항
word의 길이는 1 이상 5 이하입니다.
word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다
word : "AAAAE" result: 6
사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA", "AAA", "AAAA", "AAAAA", "AAAAE", ... 와 같습니다. "AAAAE"는 사전에서 6번째 단어입니다.

List<String>으로 한개씩 A~ UUUUU를 넣어서 확인하고
list.indexOf(word)+1로 찾는 방식으로 가면 될 것 같다.

List<String>에 어떻게 하나씩 넣냐 가 문제인데.
List<String> dictionary = new ArrayList<>();

for (char ch = 'A'; ch <= 'UUUUU'; ch++) {
    dictionary.add(String.valueOf(ch)); // 또는 "" + ch
}
이렇게 하면 될려나?
피드백
DFS char[] vowels = {A,E,I,O,U}
종료 조건은 단어길이가 5를 넘어가면 더 이상 탐색하지 않고 return
 */
class Dictionary{
    private  final String[] vowels ={"A","E","I","O","U"};
    private final List<String> dictionary = new ArrayList<>();

    private void generate(String currentWord){
        if(currentWord.length()> 5){
            return;
        }
        if(!currentWord.isEmpty()){
            dictionary.add(currentWord);
        }
        for(String v : vowels){
            generate(currentWord+v);
        }
    }
    public int findWord(String word){
        generate("");
        return dictionary.indexOf(word)+ 1;
    }
}
public class TestWord {
    public int solution(String word) {
        Dictionary dic = new Dictionary();
        return dic.findWord(word);
    }

    public static void main(String[] args) {
        String a = "I";
        TestWord tw = new TestWord();
        System.out.println(tw.solution(a));

    }
}
