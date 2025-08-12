
fruit_basket = {
    "mango": 280,
    "chikkoo": 180,
    "moosambi": 150,
    "guava": 45
}

fruit_to_lookout_for = input("What are you looking for? ").lower()

if(fruit_to_lookout_for in fruit_basket):
    print("Yes, this is available")
else:
    print("No, this is not available")