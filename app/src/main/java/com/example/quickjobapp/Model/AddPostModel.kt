package com.example.quickjobapp.Model

data class AddPostModel (
    var jobId: String? = null,
    var location: String? = null,
    var title: String? = null,
    var role: String? = null,
    var description: String? = null,
    var salary: String? = null
)