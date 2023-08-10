public class Problem14226 {
    static int input;
    static boolean[][] visited = new boolean[1001][1001];
    static Emo num;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        input = sc.nextInt();

        Queue<Emo> queue = new LinkedList<>();
        queue.offer(new Emo(1,0,0));

        while (!queue.isEmpty()){

            num = queue.poll();
            if(num.screen == input){
                System.out.println(num.time);
                return;
            }

            if(!visited[num.screen][num.screen]){
                queue.offer(new Emo(num.screen, num.screen, num.time + 1));
                visited[num.screen][num.screen] = true;
            }

            if(num.screen + num.clip <= 1000 && !visited[num.clip + num.screen][num.clip]){
                queue.offer(new Emo(num.screen + num.clip, num.clip, num.time+1));
                visited[num.clip + num.screen][num.clip] = true;
            }

            if(num.screen -1 >= 0 && !visited[num.screen - 1][num.clip]){
                queue.offer(new Emo(num.screen - 1, num.clip, num.time + 1));
                visited[num.screen - 1 ][num.clip] = true;
            }
        }
    }

    public static class Emo{
        int screen, clip, time;
        public Emo(int screen, int clip, int time){
            this.screen = screen;
            this.clip = clip;
            this.time = time;
        }
    }
}