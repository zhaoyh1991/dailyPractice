package com.zyh.daily.algr;

import java.util.Stack;

/**
 *
 * implement of min stack
 *
 * the idea is if we pop the minest num there should be another num to be the minest. if you are confused pls take the  property of stack
 *(LIFO) into consideration .
 *
 * Created by zhaoyh on 2017/9/11.
 */
public class MinStack {
   private  Stack<Integer> numstack=new Stack<>();
   private  Stack<Integer> minstack=new Stack<>();

    /**
     * add an ele to the stack
     * @param i
     */
    public void put(Integer i){
        if(numstack.isEmpty()){
            numstack.push(i);
            minstack.push(i);
        }else{
            if(minstack.get(minstack.size()-1)>i){
                minstack.push(i);
            }
            numstack.push(i);
        }
    }

    /**
     * pop the ele
     * @return
     */
    public Integer pop(){
        if(numstack.isEmpty()){
            throw new IndexOutOfBoundsException();
        }else{
          Integer res=  numstack.pop();
          if(minstack.get(minstack.size()-1)==res){
              minstack.pop();
          }
          return res;
        }
    }

    /**
     * find the min num in the stack time cost o(1)
     * @return
     */
    public Integer getMin(){
        if (minstack.isEmpty()) throw new IndexOutOfBoundsException();
        return minstack.pop();
    }

}
