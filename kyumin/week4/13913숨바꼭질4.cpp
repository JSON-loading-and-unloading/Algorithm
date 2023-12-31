#include<iostream>
#include<vector>
#include<queue>

using namespace std;

int n,k;
int checkPos[100100];
queue<pair<int,int> > q;
vector<int> resultPath;
int resultTime=10e8;

void input(){
    cin>>n>>k;
    for(int i=0;i<=100000;i++){
        checkPos[i]=-1;
    }
}

void output(){
    cout<<resultTime<<'\n';
    int start=k;
    while(true){
        resultPath.push_back(start);
        if(start==n) break;
        start=checkPos[start];
    }
    for(int i=resultPath.size()-1;i>=0;i--){
        cout<<resultPath[i]<<' ';
    }
    cout<<'\n';
}

void cal(){
    q.push(make_pair(n,0));
    while(!q.empty()){
        pair<int,int> popTmp = q.front();
        q.pop();

        if(popTmp.first==k){
            resultTime=popTmp.second;
            return;
        }

        if(popTmp.first+1<=100000){
            if(checkPos[popTmp.first+1]==-1){
                checkPos[popTmp.first+1]=popTmp.first;

                q.push(make_pair(popTmp.first+1, popTmp.second+1));
            }
        }

        if(popTmp.first-1>=0){
            if(checkPos[popTmp.first-1]==-1){
                checkPos[popTmp.first-1]=popTmp.first;

                q.push(make_pair(popTmp.first-1, popTmp.second+1));
            }
        }

        if(popTmp.first*2<=100000){
            if(checkPos[popTmp.first*2]==-1){
                checkPos[popTmp.first*2]=popTmp.first;

                q.push(make_pair(popTmp.first*2, popTmp.second+1));
            }
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