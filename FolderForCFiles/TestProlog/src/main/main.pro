/* README
   - Fact - is a statement about an existence of objects reltionship. Always true
        Structure:
            <relationship name>(obj1,obj2...objN)
        Rules
            name start with _ or eny small char. Name == predicate
            . at end of fact 
        Exapmles
            Anna - mother of Eug: mother(Anna,Eug).
            Pete likes Mary:      likes(Pete, Mary). 
            ..etc
   - Data Base(in Prolog) - complex of facts
   - Rules - is a statements, truth value depends on the values of truth predicates
        Structure:
            <rule name>:-<rule body(Data Base == condition condition == subgoal)>
            Q:-P1,P2...Pn.
            Q - rule. Pi - subgoal. "," == logical &&. "." - end of rule
            :- == if
        Rule is true when all subgoals true
        Example
            Masha and Mikol - parents of Ann: parents(Ann,Masha,Mikola):-
                                                    mother(Ann,Masha),
                                                    father(Ann,Mikola).
   - Knowladge base - complex of facts ans rules
   - Goal - task for prolog programm
        Example:
        Anna`s father, Mikola: ?- father(Mikola,Ann).s
*/


program :- write('Hello, world!').
