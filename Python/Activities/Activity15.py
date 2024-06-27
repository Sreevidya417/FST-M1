try:
    #Name = "Rama"
    print(Name)
    #print(Name1)
except NameError:
    print("Name hasn't been defined yet.")
try:
    nume = 4
    deno = 0
    div = nume/deno
    print (div)
except ZeroDivisionError:
    print("Cannot divide 0")