package com.example.present_list

import android.util.Log
import android.view.View

val TAG = "ListActivity"
var db: AppDatabase? = null
var contactsList = mutableListOf<Contacts>()

// 초기화
db = AppDatabase.getInstance(this)

// 이전에 저장한 내용 모두 불러오기 + 추가
val savedContacts = db!!.contactsDao().getAll()
if(savedContacts.isNotEmpty()) {
    contactsList.addAll(savedContacts)
}

// 아이템 클릭 및 취소
val adapter = ContactsListAdapter(contactsList)
adapter.setItemClickListener(object: ContactsListAdapter.OnItemClickListener{
    override fun onClick(v: View, position, Int) {

        val contacts = contactsList[position]

        contactsList.removeAt(position) // 취소, 리스트에서 삭제
        adapter.notifyDataSetChanged()  // 리스트뷰 갱신

        Log.d(TAG, "remove item($position).name:${contacts.name}")
    }
})
mRecyclerView.adapter = adapter



// 결제 버튼 클릭 : 거래내역 추가
button.setOnClickListener {

    // 랜덤 번호 만들기
    val random = Random()
    val 
}