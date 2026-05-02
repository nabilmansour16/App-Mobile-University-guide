package com.umbb.mobguide.data;

import com.umbb.mobguide.model.Department;
import com.umbb.mobguide.model.Faculty;

import java.util.ArrayList;

public class DataProvider {

        private static ArrayList<Faculty> faculties;

        public static ArrayList<Faculty> getFaculties() {
                if (faculties != null)
                        return faculties;
                faculties = new ArrayList<>();

                // ─────────────────────────────────────────────
                // Faculty 1 — Sciences
                // ─────────────────────────────────────────────
                ArrayList<Department> sciDepts = new ArrayList<>();

                ArrayList<String> bioSpec = new ArrayList<>();
                bioSpec.add("Ecology & Environment");
                bioSpec.add("Plant Biology");
                bioSpec.add("Animal Biology");
                bioSpec.add("Biochemistry");
                sciDepts.add(new Department(101, "Department of Natural Sciences",
                                "Explores the life sciences, ecology, and environmental studies through " +
                                                "laboratory and field research, training specialists in biology and related disciplines.",
                                bioSpec, "naturesciences@umbb.dz", "+213 24 81 60 01"));

                ArrayList<String> csSpec = new ArrayList<>();
                csSpec.add("Software Engineering");
                csSpec.add("Networks & Telecommunications");
                csSpec.add("Artificial Intelligence");
                csSpec.add("Database Systems");
                sciDepts.add(new Department(102, "Department of Computer Science",
                                "Offers programs in software development, networks, AI, and information systems. " +
                                                "Students gain strong theoretical and practical foundations in computing.",
                                csSpec, "cs@umbb.dz", "+213 24 81 60 02"));

                ArrayList<String> mathSpec = new ArrayList<>();
                mathSpec.add("Pure Mathematics");
                mathSpec.add("Applied Mathematics");
                mathSpec.add("Statistics & Probability");
                sciDepts.add(new Department(103, "Department of Mathematics",
                                "Covers algebra, analysis, geometry, and statistics. The department trains " +
                                                "students to apply mathematical reasoning to real-world problems.",
                                mathSpec, "math@umbb.dz", "+213 24 81 60 03"));

                ArrayList<String> physSpec = new ArrayList<>();
                physSpec.add("Optics & Photonics");
                physSpec.add("Condensed Matter Physics");
                physSpec.add("Nuclear Physics");
                sciDepts.add(new Department(104, "Department of Physics",
                                "Provides rigorous training in classical and modern physics, enabling students " +
                                                "to conduct scientific research and contribute to technological innovation.",
                                physSpec, "physics@umbb.dz", "+213 24 81 60 04"));

                ArrayList<String> chemSpec = new ArrayList<>();
                chemSpec.add("Organic Chemistry");
                chemSpec.add("Inorganic Chemistry");
                chemSpec.add("Analytical Chemistry");
                sciDepts.add(new Department(105, "Department of Chemistry",
                                "Offers theoretical and practical knowledge in various fields of chemistry, " +
                                                "preparing students for careers in research, industry, and education.",
                                chemSpec, "chemistry@umbb.dz", "+213 24 81 60 05"));

                ArrayList<String> earthSpec = new ArrayList<>();
                earthSpec.add("Geology");
                earthSpec.add("Geophysics");
                earthSpec.add("Mineralogy");
                sciDepts.add(new Department(106, "Department of Earth Sciences",
                                "Focuses on the study of the Earth's structure, processes, and resources, " +
                                                "training professionals in geology, geophysics, and environmental geology.",
                                earthSpec, "earthsciences@umbb.dz", "+213 24 81 60 06"));

                faculties.add(new Faculty(1,
                                "Faculty of Sciences",
                                "The Faculty of Sciences at UMBB is a pillar of scientific education in the " +
                                                "Boumerdès region. It offers a wide range of programs spanning natural sciences, "
                                                +
                                                "mathematics, physics, and computer science, preparing graduates for careers "
                                                +
                                                "in research, industry, and education.",
                                "sciences@umbb.dz",
                                "+213 24 81 60 00",
                                "Faculty of Sciences, UMBB Campus, Boumerdès 35000, Algeria",
                                36.7533, 3.4591,
                                sciDepts));

                // ─────────────────────────────────────────────
                // Faculty 2 — Engineering
                // ─────────────────────────────────────────────
                ArrayList<Department> engDepts = new ArrayList<>();

                ArrayList<String> civilSpec = new ArrayList<>();
                civilSpec.add("Structural Engineering");
                civilSpec.add("Geotechnics");
                civilSpec.add("Hydraulics");
                civilSpec.add("Urban Planning");
                engDepts.add(new Department(201, "Department of Civil Engineering",
                                "Focuses on the design and construction of infrastructure including buildings, " +
                                                "bridges, roads, and water systems. Students acquire skills in structural analysis "
                                                +
                                                "and project management.",
                                civilSpec, "civil@umbb.dz", "+213 24 82 70 01"));

                ArrayList<String> mechSpec = new ArrayList<>();
                mechSpec.add("Thermodynamics & Energy");
                mechSpec.add("Manufacturing & Production");
                mechSpec.add("Robotics & Automation");
                engDepts.add(new Department(202, "Department of Mechanical Engineering",
                                "Covers the design, analysis, and manufacturing of mechanical systems. " +
                                                "Programs integrate thermodynamics, fluid mechanics, and advanced manufacturing "
                                                +
                                                "techniques.",
                                mechSpec, "mech@umbb.dz", "+213 24 82 70 02"));

                ArrayList<String> elecSpec = new ArrayList<>();
                elecSpec.add("Power Systems");
                elecSpec.add("Electronics & Microelectronics");
                elecSpec.add("Control & Instrumentation");
                engDepts.add(new Department(203, "Department of Electrical Engineering",
                                "Provides training in power electronics, control systems, and telecommunications. " +
                                                "Graduates are prepared for roles in energy, industry, and telecommunications sectors.",
                                elecSpec, "elec@umbb.dz", "+213 24 82 70 03"));

                ArrayList<String> chemEngSpec = new ArrayList<>();
                chemEngSpec.add("Process Engineering");
                chemEngSpec.add("Petrochemicals");
                chemEngSpec.add("Environmental Engineering");
                engDepts.add(new Department(204, "Department of Chemical Engineering",
                                "Combines principles of chemistry, physics, and mathematics to solve problems " +
                                                "involving the production or use of chemicals, fuel, drugs, and food.",
                                chemEngSpec, "chemeng@umbb.dz", "+213 24 82 70 04"));

                ArrayList<String> matSpec = new ArrayList<>();
                matSpec.add("Metallurgy");
                matSpec.add("Polymers");
                matSpec.add("Ceramics");
                engDepts.add(new Department(205, "Department of Materials Engineering",
                                "Focuses on the discovery and design of new materials, emphasizing the " +
                                                "relationship between the structure of materials and their properties.",
                                matSpec, "materials@umbb.dz", "+213 24 82 70 05"));

                faculties.add(new Faculty(2,
                                "Faculty of Engineering",
                                "The Faculty of Engineering offers world-class technical education across civil, " +
                                                "mechanical, and electrical disciplines. It maintains strong partnerships with "
                                                +
                                                "Algerian industry and research institutions, equipping graduates with the skills "
                                                +
                                                "to drive national development.",
                                "engineering@umbb.dz",
                                "+213 24 82 70 00",
                                "Faculty of Engineering, UMBB Campus, Boumerdès 35000, Algeria",
                                36.7521, 3.4578,
                                engDepts));

                // ─────────────────────────────────────────────
                // Faculty 3 — Economics, Commerce & Management
                // ─────────────────────────────────────────────
                ArrayList<Department> ecoDepts = new ArrayList<>();

                ArrayList<String> mgmtSpec = new ArrayList<>();
                mgmtSpec.add("Strategic Management");
                mgmtSpec.add("Human Resources Management");
                mgmtSpec.add("Entrepreneurship");
                ecoDepts.add(new Department(301, "Department of Management",
                                "Prepares future managers and entrepreneurs through courses in organizational " +
                                                "theory, strategic planning, and human resources. Graduates lead businesses "
                                                +
                                                "across multiple sectors.",
                                mgmtSpec, "management@umbb.dz", "+213 24 83 50 01"));

                ArrayList<String> finSpec = new ArrayList<>();
                finSpec.add("Banking & Financial Markets");
                finSpec.add("Corporate Finance");
                finSpec.add("Insurance & Risk Management");
                ecoDepts.add(new Department(302, "Department of Finance",
                                "Covers financial theory, banking operations, and investment analysis. " +
                                                "Students develop skills in financial planning, accounting, and risk assessment "
                                                +
                                                "relevant to both public and private sectors.",
                                finSpec, "finance@umbb.dz", "+213 24 83 50 02"));

                ArrayList<String> comSpec = new ArrayList<>();
                comSpec.add("International Trade");
                comSpec.add("Marketing");
                comSpec.add("E-Commerce");
                ecoDepts.add(new Department(303, "Department of Commerce",
                                "Focuses on marketing, international trade, and digital commerce. Programs " +
                                                "combine theoretical frameworks with practical business case studies to "
                                                +
                                                "prepare graduates for competitive markets.",
                                comSpec, "commerce@umbb.dz", "+213 24 83 50 03"));

                ArrayList<String> accSpec = new ArrayList<>();
                accSpec.add("Financial Accounting");
                accSpec.add("Auditing");
                accSpec.add("Taxation");
                ecoDepts.add(new Department(304, "Department of Accounting",
                                "Provides comprehensive education in financial reporting, auditing, and taxation, " +
                                                "preparing students for professional accounting certifications and careers.",
                                accSpec, "accounting@umbb.dz", "+213 24 83 50 04"));

                ArrayList<String> econSpec = new ArrayList<>();
                econSpec.add("Microeconomics");
                econSpec.add("Macroeconomics");
                econSpec.add("Development Economics");
                ecoDepts.add(new Department(305, "Department of Economics",
                                "Explores economic theories, policies, and quantitative methods to analyze " +
                                                "resource allocation, economic growth, and public policy.",
                                econSpec, "economicsdep@umbb.dz", "+213 24 83 50 05"));

                faculties.add(new Faculty(3,
                                "Faculty of Economics, Commerce & Management",
                                "This faculty is dedicated to training future economists, managers, and " +
                                                "business leaders. Through a rigorous curriculum blending theory and practice, "
                                                +
                                                "it equips students with the analytical and managerial skills demanded by "
                                                +
                                                "Algeria's growing economy.",
                                "economics@umbb.dz",
                                "+213 24 83 50 00",
                                "Faculty of Economics, UMBB Campus, Boumerdès 35000, Algeria",
                                36.7545, 3.4602,
                                ecoDepts));

                // ─────────────────────────────────────────────
                // Faculty 4 — Law
                // ─────────────────────────────────────────────
                ArrayList<Department> lawDepts = new ArrayList<>();

                ArrayList<String> privSpec = new ArrayList<>();
                privSpec.add("Civil Law");
                privSpec.add("Commercial Law");
                privSpec.add("Family Law");
                privSpec.add("Labour Law");
                lawDepts.add(new Department(401, "Department of Private Law",
                                "Covers civil, commercial, and family law. Students gain deep knowledge of " +
                                                "contractual relationships, property rights, and dispute resolution in private "
                                                +
                                                "legal contexts.",
                                privSpec, "privatelaw@umbb.dz", "+213 24 84 40 01"));

                ArrayList<String> pubSpec = new ArrayList<>();
                pubSpec.add("Constitutional Law");
                pubSpec.add("Administrative Law");
                pubSpec.add("International Law");
                pubSpec.add("Public Finance Law");
                lawDepts.add(new Department(402, "Department of Public Law",
                                "Trains students in constitutional, administrative, and international law. " +
                                                "Graduates pursue careers in public administration, diplomacy, and the judiciary.",
                                pubSpec, "publiclaw@umbb.dz", "+213 24 84 40 02"));

                ArrayList<String> polSpec = new ArrayList<>();
                polSpec.add("Political Theory");
                polSpec.add("Comparative Politics");
                polSpec.add("Public Administration");
                lawDepts.add(new Department(403, "Department of Political Science",
                                "Examines political systems, behavior, and institutions, equipping students " +
                                                "with analytical skills for careers in government, journalism, and research.",
                                polSpec, "politicalscience@umbb.dz", "+213 24 84 40 03"));

                ArrayList<String> irSpec = new ArrayList<>();
                irSpec.add("Diplomacy");
                irSpec.add("Global Security");
                irSpec.add("International Organizations");
                lawDepts.add(new Department(404, "Department of International Relations",
                                "Explores the interactions between nations, international organizations, and " +
                                                "non-governmental actors, preparing students for diplomatic and international roles.",
                                irSpec, "internationalrelations@umbb.dz", "+213 24 84 40 04"));

                faculties.add(new Faculty(4,
                                "Faculty of Law",
                                "The Faculty of Law at UMBB offers comprehensive legal education covering " +
                                                "both private and public law. Students develop critical thinking and argumentation "
                                                +
                                                "skills essential for careers in law, government, and international organisations.",
                                "law@umbb.dz",
                                "+213 24 84 40 00",
                                "Faculty of Law, UMBB Campus, Boumerdès 35000, Algeria",
                                36.7510, 3.4565,
                                lawDepts));

                return faculties;
        }

        public static Faculty getFacultyById(int id) {
                for (Faculty f : getFaculties()) {
                        if (f.getId() == id)
                                return f;
                }
                return null;
        }

        public static Department getDepartmentById(int id) {
                for (Faculty f : getFaculties()) {
                        for (Department d : f.getDepartments()) {
                                if (d.getId() == id)
                                        return d;
                        }
                }
                return null;
        }

        public static Faculty getFacultyContainingDepartment(int departmentId) {
                for (Faculty f : getFaculties()) {
                        for (Department d : f.getDepartments()) {
                                if (d.getId() == departmentId)
                                        return f;
                        }
                }
                return null;
        }
}
