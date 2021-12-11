package com.company;

public final class MyString {
    private char [] str;

    public MyString() {};
    public MyString(char value[]){
        this.str = value;
    }
    public MyString(MyString original){
        this.str = original.str;
    }
    public MyString(String original){
        str = original.toCharArray();
    }

    public int length(){
        return str.length;
    }

    public int compareTo(MyString anotherString){
        char[] s1 = str;
        char[] s2 = anotherString.str;
        int a;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < s1.length; i++){
            sum1 += s1[i];
        }
        for (int i = 0; i < s2.length; i++){
            sum2 += s2[i];
        }
        a = sum1 - sum2;
        return a;
    }

    public char charAt(int index){
        return str[index];
    }

    public MyString concat(MyString str1){
        char [] i = new char [str.length + str1.str.length];
        for (int a = 0; a < str.length; a++){
            i[a] = str[a];
        }
        for (int a = str.length; a < i.length; a++) {
            i[a] = str1.str[a - str.length];
        }
        return new MyString(i);
    }

    @Override
    public String toString() {
        return String.valueOf(str);
    }

    public boolean isEmpty(){
        if (str.length != 0)
            return false;
        else
            return true;
    }

    public MyString substring(int beginIndex, int endIndex){
        char [] a = new char[endIndex - beginIndex + 1];
        for (int j = 0; beginIndex != (endIndex+1); j++){
            a[j] = str[beginIndex];
            beginIndex++;
        }
        return new MyString(a);
    }

    public MyString trim(){
        int i = 0;
        while (i < str.length){
            if (i>0 && str[i-1] != ' ' && str[i+1] != ' ')
                i++;
            if (str[i] == ' '){
                for (int j = i; j < str.length; j++){
                    str[j] = str[i];
                }
                str = new char [str.length - 1];
            }
            else
                i++;
        }
        return new MyString(str);
    }
}
