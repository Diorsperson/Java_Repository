import java.util.ArrayList;
import java.util.Collections;

public class next_permutation {
    //获取下一个排列
    // 参数：list 排列列表 ，first 开始索引，last 结束索引
    // 返回值： 是否找到下一个索引
    static boolean permute(ArrayList<Integer> list, Integer first, Integer last){
        // 如果排列长度为0，则不存在下一个排列
        if(first.equals(last))return false;
        Integer i = last;
        while(true){
            Integer ii = i;
            i--;
            Integer resi = list.get(i);
            // 从左到右找到第一个arr[i - 1] < arr[i] 的索引
            if(resi < list.get(ii)){
                Integer j = last;
                // 找到比arr[i - 1]大的最小的数，然后交换二者，这样使得字典序增幅最小，获得的是下一个排列。
                // 因为 在arr[i-1]的右边，有arr[i] > arr[i-1]，所以从arr的右边向左遍历，
                // 找到第一个比arr[i - 1]大的数就是找到比arr[i - 1]大的最小的数
                while(!(resi < list.get(j)))j--;
                // 交换arr[i - 1]和arr[j]
                Collections.swap(list,i,j);
                // 反转arr[i+1]到arr[last]使得排列字典序最小，因为arr[i]的右边是降序的，反转后就是升序，保证了字典序最小。
                Collections.reverse(list.subList(ii,last+1));
                return true;
            }
            if(i.equals(first)){
                Collections.reverse(list.subList(first,last+1));
                return false;
            }
        }
    }
}
