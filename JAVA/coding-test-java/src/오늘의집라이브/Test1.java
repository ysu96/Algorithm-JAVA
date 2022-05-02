package 오늘의집라이브;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Data{
    int num;
}

class NewIterator implements Iterator<Data>{

    public void sum (NewIterator iter){
        // o(1)
        // iter2 를
    }

    @Override
    public boolean hasNext() {

        return false;
    }

    @Override
    public Data next() {
        return null;
    }
}

public class Test1 {
    // 두 개의 정렬된 iterator가 주어졌을 때 하나의 정렬된 iterator를 반환하는 메서드를 작성하시오

    Iterator<Data> getCombinedIterator(Iterator<Data> in1, Iterator<Data> in2){
        // 새로운 이터레이터
        List<Data> list = new ArrayList<>();
        Data n1 = null, n2 = null;
        if(in1.hasNext()) n1 = in1.next();
        if(in2.hasNext()) n2 = in2.next();

        while(in1.hasNext() || in2.hasNext()){
            if(n1.num < n2.num){
                list.add(n1);
                if(in1.hasNext()) n1 = in1.next();
                else{
                    while(in2.hasNext()){
                        n2 = in2.next();
                        list.add(n2);
                    }
                }
            }else{
                list.add(n2);
                if(in2.hasNext()) n2 = in2.next();
                else{
                    while(in1.hasNext()){
                        n1 = in1.next();
                        list.add(n1);
                    }
                }
            }
        }

        Iterator<Data> iter = list.iterator();
        return iter;
        // 맨 앞에서부터 두 이터레이터의 숫자를 비교해서
        //  더 작은 것을 이터레이터에 넣고
    }

}
