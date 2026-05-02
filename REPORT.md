# UMBB MobGuide — Project Report

**Application Name:** UMBB MobGuide  
**University:** Université M'hamed Bougara de Boumerdès (UMBB), Algeria  
**Platform:** Android (Java + XML)  
**Min SDK:** 21 (Android 5.0 Lollipop) | **Target SDK:** 34  
**Date:** April 2026

---

## 1. Introduction

### 1.1 Purpose

UMBB MobGuide is a native Android mobile application designed to serve as a digital
reference guide for students, visitors, and staff of the University of Boumerdès
(UMBB) in Algeria. The app provides structured, readily accessible information about
the university's academic faculties and their constituent departments, including
contact details, physical addresses, GPS coordinates, and specialty programs.

### 1.2 Context

The University of Boumerdès (Université M'hamed Bougara de Boumerdès) is one of
Algeria's leading higher education institutions, founded in 1981. It hosts thousands
of students across four major faculties. Prior to this application, accessing accurate
and up-to-date contact or structural information required navigating the university
website or physically visiting administrative offices.

### 1.3 Objectives

- Provide a clear, browsable directory of all faculties and departments.
- Enable direct contact (phone, email, SMS) and map navigation from within the app.
- Offer a full-text search across the entire university structure.
- Support bilingual access in English and Arabic.
- Deliver a clean, professional, Material Design user experience.

---

## 2. Application Architecture

### 2.1 Java Classes and Their Roles

| Class | Package | Role |
|---|---|---|
| `Department.java` | `model` | Data model: department id, name, description, specialties, email, phone |
| `Faculty.java` | `model` | Data model: faculty id, name, description, email, phone, address, lat/lng, departments list |
| `DataProvider.java` | `data` | Static data store; returns `ArrayList<Faculty>` with all UMBB data; helper lookup methods |
| `FacultyAdapter.java` | `adapter` | `BaseAdapter` for faculty `ListView`; inflates `row_faculty.xml`; ViewHolder pattern |
| `DepartmentAdapter.java` | `adapter` | `BaseAdapter` for department `ListView`; inflates `row_department.xml`; ViewHolder pattern |
| `SearchResultAdapter.java` | *(root)* | `BaseAdapter` for search results list; renders type badge (Faculty/Department) |
| `MainActivity.java` | *(root)* | Home/splash screen; Explore button; language toggle via overflow menu |
| `FacultyListActivity.java` | *(root)* | Shows all faculties in a `ListView` using `FacultyAdapter`; navigates to detail |
| `FacultyDetailActivity.java` | *(root)* | Shows full faculty details; Call/Email/SMS/Maps buttons; department sub-list |
| `DepartmentDetailActivity.java` | *(root)* | Shows full department details; specialties list; Call/Email/SMS buttons |
| `SearchActivity.java` | *(root)* | `SearchView` with live filtering across all faculties and departments |

### 2.2 XML Layout Files and Their Purpose

| File | Purpose |
|---|---|
| `activity_main.xml` | Hero banner with UMBB logo, welcome card, stats row (faculties/depts/founded), Explore button |
| `activity_faculty_list.xml` | Toolbar + `ListView` for all faculties |
| `activity_faculty_detail.xml` | Scrollable detail: info card, contact rows, 4 action buttons, departments `ListView` |
| `activity_department_detail.xml` | Scrollable detail: info card, contact rows, 3 action buttons, specialties `LinearLayout` |
| `activity_search.xml` | Toolbar + expanded `SearchView` + results `ListView` |
| `row_faculty.xml` | Card-style list row: circle icon, bold name (15sp), gray description (13sp), chevron |
| `row_department.xml` | Linear list row: amber circle icon, bold name, gray description, chevron |
| `row_search_result.xml` | Search result row: coloured type badge, result name, chevron |

### 2.3 Resource Files

| File | Purpose |
|---|---|
| `values/colors.xml` | Brand palette — deep blue `#1A237E`, amber `#FFC107`, surfaces, text colors |
| `values/strings.xml` | All English UI strings |
| `values-ar/strings.xml` | Full Arabic translation for all UI strings |
| `values/themes.xml` | `Theme.MaterialComponents.DayNight.NoActionBar` with brand colors applied |
| `drawable/ic_umbb_logo.xml` | Shield + book vector logo (blue & gold) |
| `drawable/ic_faculty.xml` | Building vector icon |
| `drawable/ic_department.xml` | Book/document vector icon |
| `drawable/ic_phone.xml` | Phone handset vector icon |
| `drawable/ic_email.xml` | Envelope vector icon |
| `drawable/ic_sms.xml` | Chat bubble vector icon |
| `drawable/ic_location.xml` | Map pin vector icon |
| `drawable/ic_search.xml` | Magnifying glass vector icon |
| `drawable/ic_chevron_right.xml` | Right-pointing arrow for list rows |
| `drawable/ic_explore.xml` | Circular plus/explore icon for CTA button |
| `drawable/bg_icon_circle.xml` | Blue oval shape for faculty icon backgrounds |
| `drawable/bg_icon_circle_accent.xml` | Amber oval shape for department icon backgrounds |
| `drawable/bg_badge.xml` | Rounded rectangle for search type badges |
| `menu/menu_main.xml` | Overflow menu: Search icon + Language submenu (EN/AR) |
| `menu/menu_list.xml` | Toolbar menu for list screen: Search icon |

### 2.4 Navigation Flow

```
MainActivity (Home)
    │
    ├── [Explore University] ──► FacultyListActivity
    │                                   │
    │                                   ├── [Faculty Item] ──► FacultyDetailActivity
    │                                   │                            │
    │                                   │                            └── [Department Item] ──► DepartmentDetailActivity
    │                                   │
    │                                   └── [Search icon] ──► SearchActivity
    │                                                              │
    │                                                              ├── [Faculty result] ──► FacultyDetailActivity
    │                                                              └── [Department result] ──► DepartmentDetailActivity
    │
    └── [Search (overflow menu)] ──► SearchActivity
```

Data is passed between activities via `Intent.putExtra()` using integer IDs
(`FACULTY_ID`, `DEPARTMENT_ID`). Each receiving activity calls `DataProvider`
to look up the full object by ID — avoiding serialization of model objects.

---

## 3. Features Implemented

| # | Feature | Status |
|---|---|---|
| 1 | Home screen with UMBB logo, welcome text, university description | ✅ Done |
| 2 | Stats row (4 Faculties, 13 Departments, Founded 1981) | ✅ Done |
| 3 | "Explore University" button navigating to Faculty list | ✅ Done |
| 4 | Faculty list with custom adapter and card-style rows | ✅ Done |
| 5 | Faculty detail screen: full description, address, phone, email | ✅ Done |
| 6 | Call button (Intent.ACTION_DIAL) | ✅ Done |
| 7 | Email button (Intent.ACTION_SENDTO + mailto:) | ✅ Done |
| 8 | SMS button (Intent.ACTION_VIEW + smsto:) | ✅ Done |
| 9 | Locate button (geo: URI with Google Maps fallback to browser URL) | ✅ Done |
| 10 | Department list within FacultyDetailActivity | ✅ Done |
| 11 | Department detail screen: description, specialties, contact buttons | ✅ Done |
| 12 | Dynamic specialties list (programmatically added TextViews) | ✅ Done |
| 13 | SearchActivity with live SearchView filtering | ✅ Done |
| 14 | Search across both Faculties and Departments | ✅ Done |
| 15 | Coloured type badge in search results (Faculty=blue, Dept=amber) | ✅ Done |
| 16 | Language toggle (English ↔ Arabic) via overflow menu | ✅ Done |
| 17 | Arabic strings.xml with full translation | ✅ Done |
| 18 | Material Design throughout (CardView, MaterialButton, Toolbar) | ✅ Done |
| 19 | Custom row layouts (row_faculty.xml, row_department.xml) | ✅ Done |
| 20 | Back navigation on all secondary screens | ✅ Done |
| 21 | Realistic UMBB data: 4 faculties, 13 departments, specialties | ✅ Done |
| 22 | GPS coordinates on all faculties for Maps integration | ✅ Done |
| 23 | CALL_PHONE permission in AndroidManifest | ✅ Done |
| 24 | ViewHolder pattern for efficient ListView recycling | ✅ Done |

---

## 4. Features Not Implemented

| Feature | Reason |
|---|---|
| Firebase / Room database | Out of scope per requirements — static ArrayList data only |
| Push notifications | Not required by the project specification |
| Student portal / login | Not in scope — this is a public information guide |
| Photo gallery of campus | Would require image assets not available in code-only deliverable |
| Persistent locale preference (SharedPreferences) | Language reverts on full app restart; adding SharedPreferences would be a minor next step |
| Kotlin version | Requirement specified Java only |

---

## 5. Task Distribution

| Student Name | Tasks |
|---|---|
| Student 1 | `Department.java`, `Faculty.java`, `DataProvider.java`, `MainActivity.java` |
| Student 2 | `FacultyListActivity.java`, `FacultyAdapter.java`, `row_faculty.xml`, `activity_faculty_list.xml` |
| Student 3 | `FacultyDetailActivity.java`, `DepartmentDetailActivity.java`, `DepartmentAdapter.java`, `activity_faculty_detail.xml`, `activity_department_detail.xml` |
| Student 4 | `SearchActivity.java`, `SearchResultAdapter.java`, `activity_search.xml`, `row_department.xml`, `row_search_result.xml` |
| Student 5 | `colors.xml`, `strings.xml`, `values-ar/strings.xml`, `themes.xml`, all drawable vectors, `AndroidManifest.xml`, `build.gradle` |

---

## 6. Conclusion

UMBB MobGuide successfully delivers a complete, functional Android application that
serves as a digital university guide for UMBB. The app covers all four major faculties
with realistic data across 13 departments, offering direct communication channels and
map integration through standard Android Intents.

The application follows clean architectural separation — models are isolated in a
`model` package, data is centralized in `DataProvider`, adapters handle presentation
logic, and activities manage user interaction. The Material Design implementation
with the UMBB brand palette (deep blue `#1A237E` and amber `#FFC107`) provides a
professional, accessible interface aligned with the university's academic identity.

All required features from the specification have been implemented including the
optional SearchActivity and Arabic language toggle, resulting in a production-ready
codebase ready for import into Android Studio and deployment.
