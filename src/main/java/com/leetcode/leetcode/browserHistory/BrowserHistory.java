package com.leetcode.leetcode.browserHistory;

import java.util.Stack;

class BrowserHistory {

    Stack<String> visited;
    Stack<String> forward;
    String currentPage;

    public BrowserHistory(String homepage) {
        visited = new Stack<String>();
        forward = new Stack<String>();
        currentPage = homepage;
    }
    
    public void visit(String url) {
        visited.push(currentPage);
        currentPage = url;
        forward.clear();
    }
    
    public String back(int steps) {
        steps = Math.min(steps, visited.size());
        for (int i = 0; i < steps; i++){
            forward.push(currentPage);
            currentPage = visited.pop();
        }
        return currentPage;
        
    }
    
    public String forward(int steps) {
        steps = Math.min(steps, forward.size());
        for (int i = 0; i < steps; i++){
            visited.push(currentPage);
            currentPage = forward.pop();
        }
        return currentPage;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
