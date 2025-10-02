#include <unordered_map>
#include <string>

std::unordered_map<std::string, int> leight = {{"giraffe", 250}, {"fox", 40}};
leight["mouse"] = 15;
std::cout << leight["giraffe"];
leight.erase("fox");
