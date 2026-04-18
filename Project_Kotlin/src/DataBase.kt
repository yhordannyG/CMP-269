package com.example

import java.util.concurrent.ConcurrentHashMap

class Database {

    companion object {
        val studentDB = ConcurrentHashMap<String, Student>().apply {
            put("1001", Student("1001", "Alice Johnson", "Computer Science", 3))
            put("1002", Student("1002", "Brian Smith", null, 1))
            put("1003", Student("1003", "Carla Gomez", "Mathematics", 2))
        }
    }
}