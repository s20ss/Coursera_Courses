'''Implement the wheel of fortune game using python classes.
'''

'''Completed the code for declaring classes'''
'''The driver code is missing'''
import random
VOWEL_COST = 250
LETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
VOWELS = 'AEIOU'
class WOFPlayer():

    def __init__(self,name):
        self.name=name
        self.prizeMoney=0
        self.prizes=[]
    
    def addMoney(self,amt):
        self.prizeMoney = self.prizeMoney + amt
    
    def goBankrupt(self):
        self.prizeMoney=0
    
    def addPrize(self,prize):
        return (self.prizes.append(prize))
    
    def __str__(self):
        return str(self.name) +" ($" + str(self.prizeMoney) + ")"



class WOFHumanPlayer(WOFPlayer):
    def getMove(self,category,obscuredPhrase,guessed):
        input_string=input(
            str(self.name)+ " has $"+str(self.prizeMoney)+"\n\n"

"Category: "+str(category)+"\n"
"Phrase:  "+str(obscuredPhrase)+"\n"
"Guessed: "+str(guessed)+"\n\n"
+
"Guess a letter, phrase, or type 'exit' or 'pass':"
        )
        return input_string


class WOFComputerPlayer(WOFPlayer):
    SORTED_FREQUENCIES='ZQXJKVBPYGFWMUCLDRHSNIOATE'

    def __init__(self,name,difficulty):
        WOFPlayer.__init__(self,name)
        self.difficulty = difficulty
    
    def smartCoinFlip(self):
        random_int=random.randint(1, 10)
        if random_int>self.difficulty:
            return True
        else:
            False
    
    def getPossibleLetter(self,guessed):
        return_list=[]
        set_a=()
        for i in self.SORTED_FREQUENCIES:
            set_a.add(i)
        return_set= set_a - set(guessed)
        
        if self.prizeMoney<VOWEL_COST:
            return_set = return_set - set(['a','e','i','o','u'])
        return_list=list(return_set)

    def getMove(self,category,obscuredPhrase,guessed):
        possibleLetters=self.getPossibleLetter(guessed)
        if not possibleLetters:
            return 'pass'
        coin_flip=self.smartCoinFlip(self)
        if coin_flip:
            for i in self.SORTED_FREQUENCIES:
                if i in possibleLetters:
                    return i
        else:
            return random.choice(self.SORTED_FREQUENCIES)

