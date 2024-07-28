def solution(board):
    answer = 0
    length = len(board)
    for i in range(length):
        for j in range(length):
            cur = 1
            if (
                (board[i][j] == 1)
                or (j<length-1 and board[i][j+1] == 1)
                or (i<length-1 and j<length-1 and board[i+1][j+1] == 1)
                or (i<length-1 and board[i+1][j] == 1)
                or (i<length-1 and j>0 and board[i+1][j-1] == 1)
                or (j>0 and board[i][j-1] == 1)
                or (i>0 and j>0 and board[i-1][j-1] == 1)
                or (i>0 and board[i-1][j] == 1)
                or (i>0 and j<length-1 and board[i-1][j+1] == 1)
            ):
                cur = 0
            answer += cur
    return answer