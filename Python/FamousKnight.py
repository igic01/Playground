len_x = 8
len_y = 8
tiles_count = len_x * len_y
table =  [[0] * len_x for _ in range(len_y)]

def knight_run(step = 1, x = 0 , y = 0):
    global table
    if step >= tiles_count: return
    if x < 0 or y < 0 or x >= len_x or y >= len_y: return
    if table[x][y] != 0: return

    table[x][y] = step
    step += 1
    knight_run(step, x + 2, y + 1)
    knight_run(step, x + 1, y + 2)
    knight_run(step, x - 2, y + 1)
    knight_run(step, x + 2, y - 1)
    knight_run(step, x - 1, y + 2)
    knight_run(step, x + 1, y - 2)
    knight_run(step, x - 2, y - 1)
    knight_run(step, x - 1, y - 2)

knight_run()

print("Knight's Tour:")
for row in table:
    print(' '.join(f'{cell:2}' for cell in row))