#include <iostream>
#include <sstream>

using namespace std;

class Student {
    private:
    unsigned age;
    string first_name;
    string last_name;
    unsigned standard;
    
    public:
    unsigned get_age() {
        return age;
    }
    
    void set_age(unsigned age) {
        this->age = age;
    }
    
    string get_first_name() {
        return first_name;
    }
    
    void set_first_name(string first_name) {
        this->first_name = first_name;
    }
    
    string get_last_name() {
        return last_name;
    }
    
    void set_last_name(string last_name) {
        this->last_name = last_name;
    }
    
    unsigned get_standard() {
        return standard;
    }
    
    void set_standard(unsigned standard) {
        this->standard = standard;
    }
    
    string to_string() {
        ostringstream oss;
        oss << get_age() << ","
            << get_first_name() << ","
            << get_last_name() << ","
            << get_standard();
        
        return oss.str();
    }
};

int main() {
    int age, standard;
    string first_name, last_name;
    
    cin >> age >> first_name >> last_name >> standard;
    
    Student st;
    st.set_age(age);
    st.set_standard(standard);
    st.set_first_name(first_name);
    st.set_last_name(last_name);
    
    cout << st.get_age() << "\n";
    cout << st.get_last_name() << ", " << st.get_first_name() << "\n";
    cout << st.get_standard() << "\n";
    cout << "\n";
    cout << st.to_string();
    
    return 0;
}
