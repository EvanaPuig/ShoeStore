package com.udacity.shoestore.shoeDetail

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class ShoeDetailViewModel: BaseObservable() {
    private var name = ""
    private var size = 0.0
    private var company = ""
    private var description = ""

    @Bindable
    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        if (this.name != name) {
            this.name = name
            notifyPropertyChanged(BR.name)
        }
    }

    @Bindable
    fun getSize(): Double {
        return size
    }

    fun setSize(size: Double) {
        if (this.size != size) {
            this.size = size
            notifyPropertyChanged(BR.size)
        }
    }

    @Bindable
    fun getCompany(): String {
        return company
    }

    fun setCompany(company: String) {
        if (this.company != company) {
            this.company = company
            notifyPropertyChanged(BR.company)
        }
    }

    @Bindable
    fun getDescription(): String {
        return description
    }

    fun setDescription(description: String) {
        if (this.description != description) {
            this.description = description
            notifyPropertyChanged(BR.description)
        }
    }
}
