#include<iostream>
#include<vector>
using namespace std;

/**
 *  0 0 0 0 0 0 0
 *  0 0 10 10 10 10 10
 *  0 0 10 10 20 20 20
 *  0 0 10 10 20 20 20
 *  0 0 10 30 30 30 30
 *  0 0 10 30 30 45 45
 *  0 0 10 30 30 45 45
 *
 * value = max(value(idx-t)+P,value)
 */

int n;
int inputT[2000000]={0};
int inputP[2000000]={0};
int result[2000000]={0};
int tmp = 0;
int outputTmp=0;

void input(){
    cin>>n;
    for(int i=1;i<=n;i++){
        cin>>inputT[i]>>inputP[i];
    }
}

void output(){
    cout<<result[n]<<'\n';
}

void cal(){
    for(int i=1;i<=n;i++){
        result[i]=max(result[i],result[i-1]);
        if(i+inputT[i]-1>n) continue;
        if(result[i+inputT[i]-1]<result[i-1]+inputP[i]){
            result[i+inputT[i]-1]=result[i-1]+inputP[i];
        }
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