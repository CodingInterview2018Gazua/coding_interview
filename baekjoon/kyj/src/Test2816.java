import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 9. 8..
 */
public class Test2816 {
    /**
     *
     * @description 백준 2816번 디지털 티비
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String[] channelArr = new String[100];

        for(int i = 0; i < N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            channelArr[i] = st2.nextToken();
        }

        RemoteButton rb = new RemoteButton(channelArr);
        String result = rb.changeChannel();
        System.out.println(result);
    }
}

class RemoteButton{

    public String result = "";
    public String[] channelArr;
    public int pointer;
    public String channel;

    RemoteButton(String[] channelArr){
        this.channelArr = channelArr;
        this.pointer = 0;
    }

    public String changeChannel(){

//        printChannelList();

        if(!channelArr[0].equals("KBS1")) {
            downPointer();
            addButton("1");
            while (pointer > 0
                    && channelArr[pointer] != null) {
                if (!channel.equals("KBS1")) {
                    downPointer();
                    addButton("1");
                } else {
                    changeUpChannel();
                    addButton("4");
                }
            }
        }

        init();

        if(!channelArr[1].equals("KBS2")) {
            downPointer();
            addButton("1");
            while (pointer > 0
                    && !channelArr[1].equals("KBS2")
                    && channelArr[pointer] != null) {
                if (!channel.equals("KBS2")) {
                    downPointer();
                    addButton("1");
                } else {
                    changeUpChannel();
                    addButton("4");
                }
            }
        }

//        printChannelList();

        return result;
    }

    public void init(){
        this.pointer = 0;
        this.channel = "";
    }

    public void addButton(String button){
        this.result += button;
    }

    public void changeUpChannel(){
        channelArr[pointer] = channelArr[pointer - 1];
        channelArr[pointer - 1] = channel;
        pointer--;
    }

    public void downPointer(){
        pointer++;
        channel = channelArr[pointer];
    }

    public void printChannelList(){
        System.out.println("======");
        for(int i = 0; i < channelArr.length; i++){
            if(channelArr[i] != null)
                System.out.println(channelArr[i]);
        }
        System.out.println("======");
    }
}