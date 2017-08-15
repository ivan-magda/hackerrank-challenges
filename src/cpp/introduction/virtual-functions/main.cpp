#include <cmath>
#include <vector>
#include <iostream>

using namespace std;

static int PROFESSOR_CUR_ID = 1;
static int STUDENT_CUR_ID = 1;

class Person {
protected:
    string name;
    int age;
    int cur_id;

public:
    Person(int cur_id) : cur_id(cur_id) {}

    Person(const string &name, int age, int cur_id) : name(name), age(age), cur_id(cur_id) {}

    virtual void getdata() {
        string name;
        int age;

        cin >> name >> age;

        Person::name = name;
        Person::age = age;
    }

    virtual void putdata() {}
};

class Professor : public Person {
private:
    int publications;

public:
    Professor() : Person(PROFESSOR_CUR_ID++) {}

    Professor(const string &name, int age, int cur_id, int publications) : Person(name, age, cur_id),
                                                                           publications(publications) {}

    void getdata() {
        Person::getdata();

        int publications;
        cin >> publications;

        Professor::publications = publications;
    }

    void putdata() {
        cout << Person::name << ' '
             << Person::age << ' '
             << Professor::publications << ' '
             << Person::cur_id << endl;
    }
};

class Student : public Person {
private:
    static const int MARKS_COUNT = 6;

    vector<int> marks;

public:
    Student() : Person(STUDENT_CUR_ID++) {}

    int getMarksSum() const {
        int sum = 0;
        for (int i = 0; i < MARKS_COUNT; ++i) {
            sum += Student::marks[i];
        }

        return sum;
    }

    void getdata() {
        Person::getdata();

        for (int i = 0; i < MARKS_COUNT; ++i) {
            int mark;
            cin >> mark;

            Student::marks.push_back(mark);
        }
    }

    void putdata() {
        cout << Person::name << ' '
             << Person::age << ' '
             << Student::getMarksSum() << ' '
             << Person::cur_id << endl;
    }
};

int main() {
    int n, val;
    cin >> n;

    Person *person[n];
    for (int i = 0; i < n; i++) {
        cin >> val;
        if (val == 1) {
            person[i] = new Professor;
        } else {
            person[i] = new Student;
        }

        person[i]->getdata();
    }

    for (int i = 0; i < n; i++) {
        person[i]->putdata();
    }

    return 0;
}
