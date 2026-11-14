# Hourly Production Report — Android Project Starter

এটি Android Studio-তে খোলার মতো প্রাথমিক Kotlin + Jetpack Compose project scaffold।
এটি এখনো সম্পূর্ণ কার্যকর অ্যাপ বা APK নয়।

## বর্তমান কাঠামো
- Package ID: `com.hourlyproduction.report`
- Admin / Employee menu prototype
- Room database entity ও DAO scaffold
- WorkManager sync worker scaffold
- Firebase Auth ও Firestore dependencies

## APK তৈরি করার আগে প্রয়োজন
1. Android Studio-তে project খুলুন।
2. Firebase Console-এ নতুন Android app যোগ করুন।
3. Package name হিসেবে `com.hourlyproduction.report` ব্যবহার করুন।
4. Firebase থেকে `google-services.json` ডাউনলোড করে `app/` ফোল্ডারে রাখুন।
5. Google Services Gradle plugin এবং Firebase initialization পরবর্তী ধাপে যুক্ত করতে হবে।
6. Admin account, shared employee login, Firestore security rules, Room repository, sync worker, audit log এবং সব screen-এর কার্যকর logic সম্পন্ন ও পরীক্ষা করতে হবে।

## গুরুত্বপূর্ণ
- এই ZIP থেকে এখনই production-ready APK তৈরি করা যাবে না।
- Firebase credentials/configuration ছাড়া Cloud Sync কাজ করবে না।
- Employee shared login থাকায় কোন নির্দিষ্ট ব্যক্তি পরিবর্তন করেছে তা শনাক্ত করা যাবে না; audit log-এ shared account, device ID, সময় এবং entry snapshot রাখা যাবে।
- Production data-তে duplicate ঠেকাতে Firestore document ID হিসেবে প্রতিটি entry-এর স্থায়ী UUID ব্যবহার করতে হবে।
- Daily summary-তে Daily Target ও Daily Actual থাকবে; Daily Difference দেখানো হবে না।
- Monthly report অন্তর্ভুক্ত নয়।
