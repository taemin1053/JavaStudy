package codingTest.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*2차원 배열을 사용하지 않고 2차원 배열로 풀기 (객채지향)
이점: 가독성이 높아지고, 타입 안전성이 높아짐(필드명 기반 컴파일 타입 검증),
유지보수가 좋음,
정렬 편의성(Comparable 구현을 통해 객체 자체정렬기준 내장가능)
단점:
객체 생성에 따른 힙 메모리 할당 및 GC 오버헤드 존재
클래스 선언, 생성자 등 보일러플레이트 코드 발생
*/
class Job implements Comparable<Job>{
    private final int requestTime; //요청시간
    private final int duration;// 처리 시간

    public Job(int requestTime, int duration){
        this.duration = duration;
        this.requestTime = requestTime;
    }
    public int getRequestTime(){
        return requestTime;
    }
    public int getDuration() {
        return duration;
    }
    //우선순위 큐 정렬 기준: 소요시간이 짧은 순서대로 오름차순
    /*compareTo 메서드 설명
      두 객체를 비교하여 음수, 0, 양수 중 하나의 정수를 반환하는 규칙으로 동작
      1. compareTo의 동작 원리 (기준: A.compareTo(B) "A의 입장에서 B와 나를 비교해 내 위치를 어디로 정할지 결정한다")
         음수: A가 B보다 작다 A를 B보다 앞에 배치
         0: 서로 같다 순서 유지
         양수 A가 B보다 크다 A를 B보다 뒤에 배치
         Integer.compare(this.duration, other.duration) -> 결과: this.duration - other.duration(오름차순)
         (내림차순은 this와 other 위치 변경 or -Integer.compare(this.duration, other.duration);)

     */

    @Override
    public int compareTo(Job other){
        return Integer.compare(this.duration, other.duration);

    }
}
public class testHardClass {
    public int solutionHard(int[][] jobs){
        // 2. 2차원 배열 데이터를 Job 객체 리스트로 변환
        List<Job> jobList = new ArrayList<>();
        for(int[] job : jobs){
            jobList.add(new Job(job[0], job[1]));
        }
        //3.원본 작업 목록 정렬: 요청시간(requestTime) 기준 오름차순

        /*
        1.람다식 -> 이름이 없는 함수(익명 함수)다.
        동작 자체를 변수처럼 가볍게 던지기위 생긴 문법
        2. 직관적 이해
        우리가 리스트를 정렬할 때 요청 시간을 기준으로 삼으라고 명령하는 코드가 진화확인하기
        2-1 원시코드
        jobList.sort(new Comparator<Job>() {
        @Override
        public int compare(Job j1, Job j2) {
        return Integer.compare(j1.getRequestTime(), j2.getRequestTime());
        }
        });
        단점: 고작 대소 비교 하나 하려고 new Comparator 등 불피요한 껍데기가 너무 많다
        2-2 람다식
        컴파일러가 어차피 Job 두 개가 들어올 것을 알기에 껍데기를 벗기고 핵심 논리(화살표)만 남겼다
        jobList.sort((j1,j2) -> Integer.compare(j1.getRequestTime(), j2.getRequestTime()));
        해석: (j1,j2)가 들어오면 -> 화살표 오른쪽 로직을 실행해라
        3-3 메서드 참조( 압축)
        람다식도 길다고 느껴서 도입된 것 어차피 Job 객체에서 getRequestTime만 꺼내서 비교할 것이 뻔하므로 줄인다
        jobList.sort(Comparator.comparingInt(Job::getRequestTime));
        해석: Job클래스 안에 있는(::) getRequestTime 메서드를 정렬 기준으로 써라

         */
        jobList.sort(Comparator.comparingInt(Job::getRequestTime));
        // 4. 대기 큐(우선순위 큐) 생성: Job의 compareTo 기준에 따라 소요 시간이 짧은 순으로 자동 정렬, 이 우선순위 큐에는 오직 Job 객체만 들어올수 있다.
        PriorityQueue<Job> pq = new PriorityQueue<>();
        int totalResponseTime = 0; // 모든 작업의 반환 시간(완료 시점 - 요청 시점) 총합
        int currentTime = 0;       // 현재 시점 (ms)
        int jobIndex = 0;          // jobList 탐색 인덱스
        int count = 0;             // 완료된 작업 수

        while( count < jobList.size()){
            // 현재 시점(currentTime) 이하에 들어온 모든 작업을 대기 큐(pq)에 적재
            while (jobIndex < jobList.size() && jobList.get(jobIndex).getRequestTime() <= currentTime) {
                pq.offer(jobList.get(jobIndex));
                jobIndex++;
            }

            // [케이스 1] 대기 큐가 비어있는 경우 (디스크가 유휴 상태)
            // 현재 시점까지 들어온 작업이 없으므로, 다음 작업의 요청 시각으로 시간을 점프
            if (pq.isEmpty()) {
                currentTime = jobList.get(jobIndex).getRequestTime();
            }
            // [케이스 2] 대기 큐에 작업이 있는 경우
            // 소요 시간이 가장 짧은 작업을 꺼내서 처리
            else {
                Job currentJob = pq.poll();
                currentTime += currentJob.getDuration(); // 작업 수행 후 현재 시간 갱신
                totalResponseTime += (currentTime - currentJob.getRequestTime()); // 반환 시간 누적
                count++; // 처리 완료 카운트 증가
            }
        }

        // 6. 평균 반환 시간의 정수 부분 반환
        return totalResponseTime / jobList.size();
    }

    public static void main(String[] args) {
        testHardClass sol = new testHardClass();
        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
        System.out.println("평균 반환 시간: " + sol.solutionHard(jobs)); // 출력: 9
        }
    }
