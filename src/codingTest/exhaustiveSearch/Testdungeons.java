package codingTest.exhaustiveSearch;
/*
최소 필요 피로도"와 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"가 있습니다.
"최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도를 나타내며,
"소모 피로도"는 던전을 탐험한 후 소모되는 피로도를 나타냅니다.
 예를 들어 "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험하기 위해서는 유저의 현재 남은 피로도는 80 이상 이어야 하며, 던전을 탐험한 후에는 피로도 20이 소모됩니다.

이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데,
한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다.
 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때, 유저가 탐험할수 있는 최대 던전 수를 return
 예
 k:80
 dungeon: [[80,20],[50,40],[30,10]]
 return: 3
 제한 사항
 k는 1 이상 5,000 이하인 자연수입니다.
dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
dungeons의 가로(열) 길이는 2 입니다.
dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
"최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
"최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다

논리 설계 객체지향 및 생성자 설계
1.일단 이 문제를 간략하게 하면 k값으로 던전을 얼마나 많이 도냐이다. 어차피 던전의 수는 1 <= dungeon <=8 이므로 8! 이므로 생각보다 짫은 연산량이다. 따라서 전에 했던 FindePrimenumber 클래스 처럼
순열 dfs를 사용하면 될 거 같다. 여기서 dfs가 끝날때 마다 이전과 던전 돈 횟수 와 현재 던저돈 횟수를 Math.max()로 확인하면 좋을 것 같다.
dfs 설계가 많이 어렵긴한데 해보겠다..
2.이제 객체지향으로 할 수 있는 지 확인해 보겠다
2-1.두 개이상의 데이터가 하나의 의미로 묶여 데이터가 다니는가 (응집도) -> 이전에 피드백을 받았을 때 데이터 그 자체를 보지 말고 출력되는 값을 확인해 보라고 했었다.K와 dungeon의 피로도가 묶여서 카운팅되며,
 dungeon count로 이용된다고 생각한다 따라서 맞는 말인 거 같다.
2-2. 규칭이나 행위가 있나? -> 이 질문은 심플하다 순열 백트래킹의 행위가 있다. 또한 그 안에 counting을 해야한다. 또 최댓값 비교도 해야한다.
2-3. 명사가 속성을 가지나? ->이전 피드백에서 명사를 기계로 보고 속성을 기계의 작동버튼이라고 생각하라고했다. DungeonCounting이라는 클래스(기계)를 만들면, 거기에 count()라는 메소드를 만들어 순열 DFS를 돌릴 생각이다
따라서 맞는 말인 거 같다.
2-4 이제 클래스를 몇개를 구현 할 것이나 -> 여기서 main으로 하는 동작은 크게 2~3개이다. 1.DFS, 2. 카운팅, 3.최소피로도 확인과 피로도 소모 기능 ,4. Math.max()
사실상 큰틀은 DFS에서 돌아간다. 또한 각 기능들이 K, dungeon 중 최소 한개씩은 사용하므로 나누기가 애매하다. 내 생각엔 클래스 하나로 정의하는 것이 좋아 보인다.
 3. 이제 생성자를 만들어야 한다.
 우선 이 클래스가 외부 데이터를 주입 받지 않으면 작동되지 않을 기능들이 있는지 확인한다. 2-4에 있는 3번이 기능이 작동하지 못한다. 이 기능이 작동하지 못하면 DFS는 조건없 방문만하고 끝이다 조건 개념이 없으면
 제 기능을 못한다. 따라서 K 값과 dungeon 이중배열들을 값으로 받아와야한다. 그러면 외부 데이터가 아닌 클래스에서 생성해야하는 것은 무엇인가.
 int count, int maxDungeonCount, int, boolean[] visited 이렇게 있는 거 같다.

 피드백
 int count, currentK는 dfs가 독자적으로 가져가야함.
 생성자: 원본 피로도 k는 굳이 객체의 상태(필드)로 영구히 가질 필요가 없습니다. 탐색을 시작할 때만 던져주면 된다. 생성자에서는 dungeons만 주입받아 초기화하는 것이 깔끔하다.
 이름은 DungeonExplorer으로 하는 것이 좋아보인다.
 */

class DungeonExplorer{
    private  final int[][] dungeons;
    private final boolean[] visited;
    private int maxDungeonCount;
    public DungeonExplorer(int[][] dungeons){
        this.dungeons = dungeons;
        this.visited = new boolean[dungeons.length];
        this.maxDungeonCount = 0;
    }
    public int explorer(int k){
        dfs(k,0);
        return maxDungeonCount;
    }
    private void dfs(int currentK, int count){
        maxDungeonCount = Math.max(maxDungeonCount, count);
        for(int i = 0; i<dungeons.length; i++){
            if(!visited[i] && currentK >= dungeons[i][0]){
                visited[i] = true;
                dfs(currentK - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
}
public class Testdungeons {
    public int solution(int k, int[][] dungeons) {
        DungeonExplorer dun = new DungeonExplorer(dungeons);
        return dun.explorer(k);
    }

    public static void main(String[] args) {
        int a = 80;
        int[][] b = {{80,20},{50,40},{30,10}};
        Testdungeons dg = new Testdungeons();
        System.out.println(dg.solution(a,b));
    }
}
