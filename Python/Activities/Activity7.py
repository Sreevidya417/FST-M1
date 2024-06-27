number_list_to_be_summed_up = [1,2,3,4,5]
print(number_list_to_be_summed_up)
sum = 0
for item in number_list_to_be_summed_up:
    sum = sum + item

print(sum)

#Now getting inupt from user and adding it up
number_list_to_be_summed_up_input = list(input("Enter a sequence of numbers seperated by comma: ").split(","))
total  = 0
for input in number_list_to_be_summed_up_input:
    total = total + int(input)

print(total)
