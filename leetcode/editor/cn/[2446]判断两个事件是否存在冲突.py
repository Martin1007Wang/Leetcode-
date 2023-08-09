
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        starttime1=int(event1[0].split(':')[0])*60+int(event1[0].split(':')[1])
        endtime1=int(event1[1].split(':')[0])*60+int(event1[1].split(':')[1])
        starttime2=int(event2[0].split(':')[0])*60+int(event2[0].split(':')[1])
        endtime2=int(event2[1].split(':')[0])*60+int(event2[1].split(':')[1])
        # print(starttime1,endtime1)
        # print(starttime2,endtime2)
        if (starttime2<=endtime1 and endtime2>=endtime1) or (starttime1<=endtime2 and endtime1>=endtime2):
            return True
        else:
            return False
# leetcode submit region end(Prohibit modification and deletion)
