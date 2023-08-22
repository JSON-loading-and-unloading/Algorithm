#include<iostream>
#include<string>
#include<deque>

using namespace std;

int lcs[2000][2000]={0};
string first;
string second;
int maxResult=0;
deque<int> result;


void input(){
    cin>>first>>second;
}
void output(){

}
/**
 *   A C A Y K P
 *   0 0 0 0 0 0
 * C 0 1 0 0 0 0
 * A 2 0 2 0 0 0
 * P 0 0 0 0 0 3
 * C 0 4 0 0 0 0
 * A 5 0 5 0 0 0
 * K 0 0 0 0 6 0
 *
 *   0 1 1 1 1 1
 *   1 1 2 2 2 2
 *   1 1 2 2 2 3
 *   1 2 2 2 2 3
 *   1 2 3 3 3 3
 *   1 2 3 3 4 4
 *
 *   0 1 1 1 1 1
 *   2 1 2 2 2 2
 *   2 1 2 2 2 3
 *   2 4 4 4 4 3
 *   2 4 5 5 5 3
 *   2 4 5 5 6 6
 */
void cal(){
    for(int i=1;i<=second.length();i++){
        for(int j=1;j<=first.length();j++){
            if(first[j-1]==second[i-1]){
                lcs[j][i]=lcs[j-1][i-1]+1;
            }
            else{
                lcs[j][i]=max(lcs[j-1][i],lcs[j][i-1]);
            }
        }
    }
    int i = second.length();
    int j = first.length();
    while(i!=0&&j!=0){
        if(lcs[j][i-1]==lcs[j][i])
            i--;
        else if (lcs[j][i] == lcs[j-1][i])
            j--;
        else if(lcs[j][i]-1==lcs[j-1][i-1]){
            result.push_front(j);
            j--;
            i--;
        }
    }

    cout<<result.size()<<'\n';
    if(result.size()!=0){
        for(deque<int>::iterator iter = result.begin(); iter != result.end(); iter++){
            cout<<first[*iter-1];
        }
        cout<<'\n';
    }
}



void start(){
    input();
    cal();
    output();
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    start();
}