#include <string>
#include <vector>
#include<map>

using namespace std;

map<string, int> tmpMap;

int solution(vector<vector<string>> clothes) {

    for(int i=0;i<clothes.size();i++){
        auto tmp = tmpMap.find(clothes[i][1]);
        if(tmp != tmpMap.end()){
            (tmp->second)++;
        }else{
            tmpMap.insert({clothes[i][1], 2});
        }
    }
    int result = 1;
    for(auto i = tmpMap.begin(); i!=tmpMap.end(); i++){
        result*=(i->second);
    }

    return result-1;
}