package tasks.first;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class FirstTaskSolution implements FirstTask {
    @Override
    public String breadthFirst(boolean[][] adjacencyMatrix, int startIndex) {
        return null;
    }

    @Override
    public Boolean validateBrackets(String s) {
        ArrayDeque<Character> states = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                states.push(s.charAt(i));
            }
            if ((s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')') && states.isEmpty()) {
                return false;
            }
            switch (s.charAt(i)) {
                case ')':
                    if (states.getFirst() == '(') {
                        states.pop();
                        break;
                    }
                case ']':
                    if (states.getFirst() == '[') {
                        states.pop();
                        break;
                    }
                case '}':
                    if (states.getFirst() == '{') {
                        states.pop();
                        break;
                    }
            }
        }
        return states.isEmpty();
    }

    @Override
    public int polishCalculation(String s) {
        int a = 0;
        ArrayList<Character> list = new ArrayList<>();
        ArrayDeque<Integer> calc = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
            if (list.get(i).isDigit(s.charAt(i))) {
                int b = Integer.parseInt(Character.toString(s.charAt(i)));
                calc.push(b);
            }
            else {
                System.out.println(calc.toString());
                if (a == 0) {
                    a = calc.getFirst();
                    calc.pop();
                    System.out.println(a);
                }
                System.out.println(calc.toString());
                switch (list.get(i)) {
                    case '+':
                        a = calc.pop() + a;
                        System.out.println(a);
                        break;
                    case '-':
                        a = calc.pop() - a;
                        System.out.println(a);
                        break;
                    case '*':
                        a = calc.pop() * a;
                        System.out.println(a);
                        break;
                    case '/':
                        a = calc.pop() / a;
                        System.out.println(a);
                        break;

                }
            }
        }
        return a;
    }
}


