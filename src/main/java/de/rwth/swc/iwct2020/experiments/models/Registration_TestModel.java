package de.rwth.swc.iwct2020.experiments.models;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import java.util.Arrays;

import static de.rwth.swc.coffee4j.model.InputParameterModel.inputParameterModel;
import static de.rwth.swc.coffee4j.model.Parameter.parameter;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintBuilder.constrain;
import static de.rwth.swc.iwct2020.experiments.util.ConstraintsHelper.implies;

public class Registration_TestModel {

    public static InputParameterModel buildModel_Registration_Correct(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                !name.equals("Edmund") || !vorname.equals("GivenNameA")
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207", "520745", "EMPTY").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Other Street"),
                                        () -> !Arrays.asList("52066", "52074").contains(plz))
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Street 479"),
                                        () -> !Arrays.asList("51688", "52074").contains(plz))
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Street 481"),
                                        () -> !Arrays.asList("51688", "52066").contains(plz))
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Incorrect(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                !name.equals("Edmund") && !vorname.equals("GivenNameA") // FIXME
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207", "520745", "EMPTY").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688")) // FIXME
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066")) // FIXME
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074")) // FIXME
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair1(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        //, constrain("Name").withName("c5").by((String name) ->
                        //        !name.equals("2352155")
                        //)
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) -> {
                                    if(name.equals("Thomas") && vorname.equals("GivenNameA")) return true;

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");
                                }
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) -> {
                            if(kommPlz.equals("B5207")) return true;
                            if(kommPlz.equals("520745")) return true;

                            return !Arrays.asList("B5207", "520745", "EMPTY").contains(kommPlz);
                        })
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) -> {
                            if(strasse.equals("Other Street") &&  plz.equals("EMPTY")) return true;
                                    return implies( () -> strasse.equals("Other Street"),
                                                    () -> plz.equals("51688"));
                                }
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                            implies(() -> plz.equals("51688"),
                                    () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) -> {
                            if(strasse.equals("Street 479") && plz.equals("EMPTY")) return true;

                            return implies( () -> strasse.equals("Street 479"),
                                            () -> plz.equals("52066"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) -> {
                            if(strasse.equals("Street 481") && plz.equals("EMPTY")) return true;

                            return implies( () -> strasse.equals("Street 481"),
                                            () -> plz.equals("52074"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair2(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
//                        , constrain("Name").withName("c5").by((String name) ->
//                                !name.equals("2352155")
//                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) -> {
                            if(name.equals("Thomas") && vorname.equals("GivenNameA")) return true;

                            return !name.equals("Edmund") && !vorname.equals("GivenNameA");
                        }
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
//                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
//                                !Arrays.asList("B5207", "520745", "EMPTY").contains(kommPlz)
//                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688")) // FIXME
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066")) // FIXME
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074")) // FIXME
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair3(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
//                        , constrain("Name").withName("c5").by((String name) ->
//                                !name.equals("2352155")
//                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) -> {
                                    if(name.equals("Thomas") && vorname.equals("GivenNameA")) return true;

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");
                        })
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) -> {
                            if(kommPlz.equals("B5207")) return true;
                            if(kommPlz.equals("EMPTY")) return true;

                            return !Arrays.asList("B5207", "520745", "EMPTY").contains(kommPlz);
                        })
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) -> {
                            if(strasse.equals("Other Street") && plz.equals("520745")) return true;
                            if(strasse.equals("Other Street") && plz.equals("EMPTY")) return true;

                            return implies( () -> strasse.equals("Other Street"),
                                            () -> plz.equals("51688"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) -> {
                            if(strasse.equals("Street 479") && plz.equals("520745")) return true;
                            if(strasse.equals("Street 479") && plz.equals("EMPTY")) return true;

                            return implies( () -> strasse.equals("Street 479"),
                                            () -> plz.equals("52066"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) -> {
                            if(strasse.equals("Street 481") && plz.equals("520745")) return true;
                            if(strasse.equals("Street 481") &&plz.equals("EMPTY")) return true;

                            return implies( () -> strasse.equals("Street 481"),
                                            () -> plz.equals("52074"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair4(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
//                        , constrain("Name").withName("c5").by((String name) ->
//                                !name.equals("2352155")
//                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) -> {
                            if(name.equals("Thomas") &&  vorname.equals("GivenNameA")) return true;

                            return !name.equals("Edmund") && !vorname.equals("GivenNameA");
                        })
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) -> {
                                    if(kommPlz.equals("B5207")) return true;
                                    if(kommPlz.equals("EMPTY")) return true;

                                    return !Arrays.asList("B5207", "520745", "EMPTY").contains(kommPlz);
                        })
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) -> {
                            if(strasse.equals("Other Street") && plz.equals("520745")) return true;

                            return implies( () -> strasse.equals("Other Street"),
                                            () -> plz.equals("51688"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) -> {
                            if(strasse.equals("Street 479") &&  plz.equals("520745")) return true;

                            return implies( () -> strasse.equals("Street 479"),
                                            () -> plz.equals("52066"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) -> {
                            if(strasse.equals("Street 481") && plz.equals("520745")) return true;

                            return implies( () -> strasse.equals("Street 481"),
                                            () -> plz.equals("52074"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair5(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
//                        , constrain("Name").withName("c5").by((String name) ->
//                                !name.equals("2352155")
//                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) -> {
                            if(name.equals("Thomas") && vorname.equals("GivenNameA")) return true;

                            return !name.equals("Edmund") && !vorname.equals("GivenNameA");
                        })
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207", /*"520745",*/ "EMPTY").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) -> {
                            if(strasse.equals("Other Street") && plz.equals("B5207")) return true;
                            if(strasse.equals("Other Street") && plz.equals("EMPTY")) return true;

                            return implies( () -> strasse.equals("Other Street"),
                                            () -> plz.equals("51688"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) -> {
                            if(strasse.equals("Street 479") && plz.equals("B5207")) return true;
                            if(strasse.equals("Street 479") && plz.equals("EMPTY")) return true;

                            return implies( () -> strasse.equals("Street 479"),
                                            () -> plz.equals("52066"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) -> {
                            if(strasse.equals("Street 481") && plz.equals("B5207")) return true;
                            if(strasse.equals("Street 481") && plz.equals("EMPTY")) return true;

                            return implies( () -> strasse.equals("Street 481"),
                                            () -> plz.equals("52074"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair6(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
//                        , constrain("Name").withName("c5").by((String name) ->
//                                !name.equals("2352155")
//                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) -> {
                            if(name.equals("Thomas") && vorname.equals("GivenNameA")) return true;

                            return !name.equals("Edmund") && !vorname.equals("GivenNameA");
                        })
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207" /*, "520745", "EMPTY"*/).contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) -> {
                            if(strasse.equals("Other Street") && plz.equals("B5207")) return true;

                            return implies( () -> strasse.equals("Other Street"),
                                            () -> plz.equals("51688"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) -> {
                            if(strasse.equals("Street 479") && plz.equals("B5207")) return true;

                            return implies( () -> strasse.equals("Street 479"),
                                            () -> plz.equals("52066"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {	if(strasse.equals("Street 481") && plz.equals("B5207")) return true;

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair7(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
//                        , constrain("Name").withName("c5").by((String name) ->
//                                !name.equals("2352155")
//                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) -> {
                            if(name.equals("Thomas") && vorname.equals("GivenNameA")) return true;

                            return !name.equals("Edmund") && !vorname.equals("GivenNameA");
                        })
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207", "520745", "EMPTY").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) -> {
                            if(strasse.equals("Other Street") && plz.equals("B5207")) return true;
                            if(strasse.equals("Other Street") && plz.equals("520745")) return true;
                            if(strasse.equals("Other Street") && plz.equals("EMPTY")) return true;

                            return implies( () -> strasse.equals("Other Street"),
                                            () -> plz.equals("51688"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) -> {
                            if(strasse.equals("Street 479") && plz.equals("B5207")) return true;
                            if(strasse.equals("Street 479") && plz.equals("520745")) return true;
                            if(strasse.equals("Street 479") && plz.equals("EMPTY")) return true;

                            return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) -> {
                            if(strasse.equals("Street 481") && plz.equals("B5207")) return true;
                            if(strasse.equals("Street 481") && plz.equals("520745")) return true;
                            if(strasse.equals("Street 481") && plz.equals("EMPTY")) return true;

                            return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair8(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
//                        , constrain("Name").withName("c5").by((String name) ->
//                                !name.equals("2352155")
//                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                {if(name.equals("Thomas") && vorname.equals("GivenNameA")) return true;
                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");}
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207", "520745" /*, "EMPTY"*/).contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) -> {
                            if(strasse.equals("Other Street") && plz.equals("B5207")) return true;
                            if(strasse.equals("Other Street") && plz.equals("520745")) return true;

                            return implies( () -> strasse.equals("Other Street"),
                                            () -> plz.equals("51688"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) -> {
                            if(strasse.equals("Street 479") && plz.equals("B5207")) return true;
                            if(strasse.equals("Street 479") && plz.equals("520745")) return true;

                            return implies( () -> strasse.equals("Street 479"),
                                            () -> plz.equals("52066"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) -> {
                            if(strasse.equals("Street 481") && plz.equals("B5207")) return true;
                            if(strasse.equals("Street 481") && plz.equals("520745")) return true;

                            return implies( () -> strasse.equals("Street 481"),
                                            () -> plz.equals("52074"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair9(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
//                        , constrain("Name").withName("c5").by((String name) ->
//                                !name.equals("2352155")
//                        )
//                        , constrain("Name").withName("c6").by((String name) ->
//                                !name.equals("Thomas")
//                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                !name.equals("Edmund") && !vorname.equals("GivenNameA") // FIXME
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList(/*"B5207", "520745",*/ "EMPTY").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) -> {
                            if(strasse.equals("Other Street") && plz.equals("EMPTY")) return true;

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));
                        })
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {	if(strasse.equals("Street 479") && plz.equals("EMPTY")) return true;
                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {	if(strasse.equals("Street 481") && plz.equals("EMPTY")) return true;
                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair10(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
//                        , constrain("Name").withName("c5").by((String name) ->
//                                !name.equals("2352155")
//                        )
//                        , constrain("Name").withName("c6").by((String name) ->
//                                !name.equals("Thomas")
//                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                !name.equals("Edmund") && !vorname.equals("GivenNameA") // FIXME
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
//                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
//                                !Arrays.asList("B5207", "520745", "EMPTY").contains(kommPlz)
//                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688")) // FIXME
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066")) // FIXME
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074")) // FIXME
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair11(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
//                        , constrain("Name").withName("c5").by((String name) ->
//                                !name.equals("2352155")
//                        )
//                        , constrain("Name").withName("c6").by((String name) ->
//                                !name.equals("Thomas")
//                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                !name.equals("Edmund") && !vorname.equals("GivenNameA") // FIXME
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList(/* "B5207", */ "520745", "EMPTY").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("520745")) return true;
                                    if(strasse.equals("Other Street") && plz.equals("EMPTY")) return true;

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {	if(strasse.equals("Street 479") && plz.equals("520745")) return true;
                                    if(strasse.equals("Street 479") && plz.equals("EMPTY")) return true;

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));
                                }
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {	if(strasse.equals("Street 481") && plz.equals("520745")) return true;
                                    if(strasse.equals("Street 481") && plz.equals("EMPTY")) return true;

                                    return implies( () -> strasse.equals("Street 481"),
                                                    () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair12(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
//                        , constrain("Name").withName("c5").by((String name) ->
//                                !name.equals("2352155")
//                        )
//                        , constrain("Name").withName("c6").by((String name) ->
//                                !name.equals("Thomas")
//                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                !name.equals("Edmund") && !vorname.equals("GivenNameA") // FIXME
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList(/*"B5207", */ "520745" /*, "EMPTY"*/).contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("520745")) return true;

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 479") && plz.equals("520745")) return true;

                                    return implies( () -> strasse.equals("Street 479"),
                                                    () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {if(strasse.equals("Street 481") && plz.equals("520745")) return true;

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair13(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
//                        , constrain("Name").withName("c5").by((String name) ->
//                                !name.equals("2352155")
//                        )
//                        , constrain("Name").withName("c6").by((String name) ->
//                                !name.equals("Thomas")
//                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                !name.equals("Edmund") && !vorname.equals("GivenNameA") // FIXME
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207", /*"520745",*/ "EMPTY").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("B5207")) return true;
                                    if(strasse.equals("Other Street") && plz.equals("EMPTY")) return true;

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 479") && plz.equals("B5207")) return true;
                                    if(strasse.equals("Street 479") && plz.equals("EMPTY")) return true;

                                    return implies( () -> strasse.equals("Street 479"),
                                                    () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {	if(strasse.equals("Street 481") && plz.equals("B5207")) return true;
                                    if(strasse.equals("Street 481") && plz.equals("EMPTY")) return true;

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair14(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
//                        , constrain("Name").withName("c5").by((String name) ->
//                                !name.equals("2352155")
//                        )
//                        , constrain("Name").withName("c6").by((String name) ->
//                                !name.equals("Thomas")
//                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                !name.equals("Edmund") && !vorname.equals("GivenNameA") // FIXME
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207" /*, "520745", "EMPTY" */).contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("B5207")) return true;

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                { if(strasse.equals("Street 479") && plz.equals("B5207")) return true;

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {if(strasse.equals("Street 481") && plz.equals("B5207")) return true;

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074")); }
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair15(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
//                        , constrain("Name").withName("c5").by((String name) ->
//                                !name.equals("2352155")
//                        )
//                        , constrain("Name").withName("c6").by((String name) ->
//                                !name.equals("Thomas")
//                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                !name.equals("Edmund") && !vorname.equals("GivenNameA") // FIXME
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207", "520745", "EMPTY").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("B5207")) return true;
                                    if(strasse.equals("Other Street") && plz.equals("520745")) return true;
                                    if(strasse.equals("Other Street") && plz.equals("EMPTY")) return true;

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 479") && plz.equals("B5207")) return true;
                                    if(strasse.equals("Street 479") && plz.equals("520745")) return true;
                                    if(strasse.equals("Street 479") && plz.equals("EMPTY")) return true;

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {	if(strasse.equals("Street 481") && plz.equals("B5207")) return true;
                                    if(strasse.equals("Street 481") && plz.equals("520745")) return true;
                                    if(strasse.equals("Street 481") && plz.equals("EMPTY")) return true;

                                    return implies( () -> strasse.equals("Street 481"),
                                                    () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair16(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
//                        , constrain("Name").withName("c5").by((String name) ->
//                                !name.equals("2352155")
//                        )
//                        , constrain("Name").withName("c6").by((String name) ->
//                                !name.equals("Thomas")
//                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                !name.equals("Edmund") && !vorname.equals("GivenNameA") // FIXME
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207", "520745" /*, "EMPTY" */).contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("B5207")) return true;
                                    if(strasse.equals("Other Street") && plz.equals("520745")) return true;

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 479") && plz.equals("B5207")) return true;
                                    if(strasse.equals("Street 479") && plz.equals("520745")) return true;

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 481") && plz.equals("B5207")) return true;
                                    if(strasse.equals("Street 481") && plz.equals("520745")) return true;

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair17(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                {	if(name.equals("2352155") && vorname.equals("GivenNameA")) return true;
                                    if(name.equals("Thomas") && vorname.equals("GivenNameA")) return true;

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");}
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList(/*"B5207", "520745",*/ "EMPTY").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {   if(strasse.equals("Other Street") && plz.equals("EMPTY")) return true;

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {	if(strasse.equals("Street 479") && plz.equals("EMPTY")) return true;

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 481") && plz.equals("EMPTY")) return true;

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair18(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                {	if(name.equals("2352155") && vorname.equals("GivenNameA")) return true;
                                    if(name.equals("Thomas") && vorname.equals("GivenNameA")) return true;

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");}
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
//                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
//                                !Arrays.asList("B5207", "520745", "EMPTY").contains(kommPlz)
//                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688")) // FIXME
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066")) // FIXME
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074")) // FIXME
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair19(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                {	if(name.equals("2352155") && vorname.equals("GivenNameA")) return true;
                                    if(name.equals("Thomas") && vorname.equals("GivenNameA")) return true;

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");}
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList(/*"B5207",*/ "520745", "EMPTY").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("520745")) return true;
                                    if(strasse.equals("Other Street") && plz.equals("EMPTY")) return true;

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 479") && plz.equals("520745")) return true;
                                    if(strasse.equals("Street 479") && plz.equals("EMPTY")) return true;

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {	if(strasse.equals("Street 481") && plz.equals("520745")) return true;
                                    if(strasse.equals("Street 481") && plz.equals("EMPTY")) return true;

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair20(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                {	if(name.equals("2352155") && vorname.equals("GivenNameA")) return true;
                                    if(name.equals("Thomas") && vorname.equals("GivenNameA")) return true;

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");}
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList(/*"B5207",*/ "520745" /*, "EMPTY"*/).contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("520745")) return true;

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 479") && plz.equals("520745")) return true;

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {if(strasse.equals("Street 481") && plz.equals("520745")) return true;

                                    return     implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair21(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                {   if(name.equals("2352155") && vorname.equals("GivenNameA")) return true;
                                    if(name.equals("Thomas") && vorname.equals("GivenNameA")) return true;

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");}
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207" /*, "520745"*/, "EMPTY").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("B5207")) return true;
                                    if(strasse.equals("Other Street") && plz.equals("EMPTY")) return true;

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 479") && plz.equals("B5207")) return true;
                                    if(strasse.equals("Street 479") && plz.equals("EMPTY")) return true;

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 481") && plz.equals("B5207")) return true;
                                    if(strasse.equals("Street 481") && plz.equals("EMPTY")) return true;

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair22(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                {	if(name.equals("2352155") && vorname.equals("GivenNameA")) return true;
                                    if(name.equals("Thomas") && vorname.equals("GivenNameA")) return true;

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");}
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207" /*, "520745", "EMPTY"*/).contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("B5207")) return true;

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 479") && plz.equals("B5207")) return true;

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {if(strasse.equals("Street 481") && plz.equals("B5207")) return true;

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair23(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) -> {
                            if(name.equals("2352155") && vorname.equals("GivenNameA")) return true;
                            if(name.equals("Thomas") && vorname.equals("GivenNameA")) return true;

                            return !name.equals("Edmund") && !vorname.equals("GivenNameA");
                        })
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207", "520745", "EMPTY").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) -> {
                            if(strasse.equals("Other Street") && plz.equals("B5207")) return true;
                            if(strasse.equals("Other Street") && plz.equals("520745")) return true;
                            if(strasse.equals("Other Street") && plz.equals("EMPTY")) return true;

                            return implies( () -> strasse.equals("Other Street"),
                                            () -> plz.equals("51688"));
                            }
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) -> {
                            if(strasse.equals("Street 479") && plz.equals("B5207")) return true;
                            if(strasse.equals("Street 479") && plz.equals("520745")) return true;
                            if(strasse.equals("Street 479") && plz.equals("EMPTY")) return true;

                            return implies( () -> strasse.equals("Street 479"),
                                            () -> plz.equals("52066"));
                            }
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) -> {
                            if(strasse.equals("Street 481") && plz.equals("B5207")) return true;
                            if(strasse.equals("Street 481") && plz.equals("520745")) return true;
                            if(strasse.equals("Street 481") && plz.equals("EMPTY")) return true;

                            return implies( () -> strasse.equals("Street 481"),
                                            () -> plz.equals("52074"));
                            }
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair24(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
                        , constrain("Name").withName("c6").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                {	if(name.equals("2352155") && vorname.equals("GivenNameA")) return true; // {name=c7") && parameterNames=(Name") && FirstName)}.
                                    if(name.equals("Thomas") && vorname.equals("GivenNameA")) return true; // {name=c7") && parameterNames=(Name") && FirstName)}.

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");}
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207", "520745" /*, "EMPTY"*/).contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("B5207")) return true; // {name=c13") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Other Street") && plz.equals("520745")) return true; // {name=c13") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {	if(strasse.equals("Street 479") && plz.equals("B5207")) return true; // {name=c15") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Street 479") && plz.equals("520745")) return true; // {name=c15") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {	if(strasse.equals("Street 481") && plz.equals("B5207")) return true; // {name=c17") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Street 481") && plz.equals("520745")) return true; // {name=c17") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair25(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
//                        , constrain("Name").withName("c6").by((String name) ->
//                                !name.equals("Thomas")
//                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                {	if(name.equals("2352155") && vorname.equals("GivenNameA")) return true;

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");}
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList(/* "B5207", "520745", */ "EMPTY").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("EMPTY")) return true; // {name=c13") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 479") && plz.equals("EMPTY")) return true; // {name=c15") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 481") && plz.equals("EMPTY")) return true; // {name=c17") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair26(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
//                        , constrain("Name").withName("c6").by((String name) ->
//                                !name.equals("Thomas")
//                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                {	if(name.equals("2352155") && vorname.equals("GivenNameA")) return true;

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");}
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
//                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
//                                !Arrays.asList("B5207", "520745", "EMPTY").contains(kommPlz)
//                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688")) // FIXME
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066")) // FIXME
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074")) // FIXME
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair27(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
//                        , constrain("Name").withName("c6").by((String name) ->
//                                !name.equals("Thomas")
//                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                {	if(name.equals("2352155") && vorname.equals("GivenNameA")) return true;

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");}
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList(/*"B5207", */"520745", "EMPTY").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("520745")) return true; // {name=c13") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Other Street") && plz.equals("EMPTY")) return true; // {name=c13") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 479") && plz.equals("520745")) return true; // {name=c15") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Street 479") && plz.equals("EMPTY")) return true; // {name=c15") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 481") && plz.equals("520745")) return true; // {name=c17") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Street 481") && plz.equals("EMPTY")) return true; // {name=c17") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair28(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
//                        , constrain("Name").withName("c6").by((String name) ->
//                                !name.equals("Thomas")
//                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                {	if(name.equals("2352155") && vorname.equals("GivenNameA")) return true;

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");}
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList(/* "B5207",*/ "520745" /*, "EMPTY"*/).contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("520745")) return true; // {name=c13") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 479") && plz.equals("520745")) return true; // {name=c15") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 481") && plz.equals("520745")) return true; // {name=c17") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair29(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
//                        , constrain("Name").withName("c6").by((String name) ->
//                                !name.equals("Thomas")
//                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                {	if(name.equals("2352155") && vorname.equals("GivenNameA")) return true;

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");}
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207" /*, "520745",*/, "EMPTY").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("B5207")) return true; // {name=c13") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Other Street") && plz.equals("EMPTY")) return true; // {name=c13") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 479") && plz.equals("B5207")) return true; // {name=c15") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Street 479") && plz.equals("EMPTY")) return true; // {name=c15") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 481") && plz.equals("B5207")) return true; // {name=c17") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Street 481") && plz.equals("EMPTY")) return true; // {name=c17") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair30(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
//                        , constrain("Name").withName("c6").by((String name) ->
//                                !name.equals("Thomas")
//                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                {	if(name.equals("2352155") && vorname.equals("GivenNameA")) return true;

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");}
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207"/*, "520745", "EMPTY"*/).contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("B5207")) return true; // {name=c13") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 479") && plz.equals("B5207")) return true; // {name=c15") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 481") && plz.equals("B5207")) return true; // {name=c17") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair31(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
//                        , constrain("Name").withName("c6").by((String name) ->
//                                !name.equals("Thomas")
//                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                {	if(name.equals("2352155") && vorname.equals("GivenNameA")) return true;

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");}
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207", "520745", "EMPTY").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {
                                    if(strasse.equals("Other Street") && plz.equals("B5207")) return true; // {name=c13") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Other Street") && plz.equals("520745")) return true; // {name=c13") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Other Street") && plz.equals("EMPTY")) return true; // {name=c13") && parameterNames=(Komm-Strasse") && Komm-PLZ)

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 479") && plz.equals("B5207")) return true; // {name=c15") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Street 479") && plz.equals("520745")) return true; // {name=c15") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Street 479") && plz.equals("EMPTY")) return true; // {name=c15") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 481") && plz.equals("B5207")) return true; // {name=c17") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Street 481") && plz.equals("520745")) return true; // {name=c17") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Street 481") && plz.equals("EMPTY")) return true; // {name=c17") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }

    public static InputParameterModel buildModel_Registration_Repair32(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Employee").values(true, false)
                        , parameter("Title").values("Mr", "Mrs")
                        , parameter("Name").values("GivenNameA", "2352155", "Edmund", "Thomas")
                        , parameter("FirstName").values("Edmund", "Sabine", "21051221", "GivenNameA")
                        , parameter("Gender").values("M", "W")
                        , parameter("Geburtsname").values("x", "EMPTY")
                        , parameter("Geburtsort").values("EMPTY", "2125")
                        , parameter("Geburtsland").values("x", "EMPTY")
                        , parameter("Familienstand").values("x", "Married")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Other Street", "Street 479", "Street 481", "EMPTY")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "EMPTY")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "EMPTY")
                        , parameter("Geburtsdatum").values("15.04.1990", "EMPTY", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("c1").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Title", "FirstName").withName("c2").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Title", "Gender").withName("c3").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mrs"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Title", "Gender").withName("c4").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Mr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").withName("c5").by((String name) ->
                                !name.equals("2352155")
                        )
//                        , constrain("Name").withName("c6").by((String name) ->
//                                !name.equals("Thomas")
//                        )
                        , constrain("Name", "FirstName").withName("c7").by((String name, String vorname) ->
                                {	if(name.equals("2352155") && vorname.equals("GivenNameA")) return true;

                                    return !name.equals("Edmund") && !vorname.equals("GivenNameA");}
                        )
                        , constrain("Geburtsort").withName("c8").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").withName("c9").by((String geburtsdatum) ->
                                !geburtsdatum.equals("EMPTY")
                        )
                        , constrain("Geburtsdatum").withName("c10").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").withName("c11").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").withName("c12").by((String kommPlz) ->
                                !Arrays.asList("B5207", "520745" /*, "EMPTY"*/).contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c13").by((String strasse, String plz) ->
                                {	if(strasse.equals("Other Street") && plz.equals("B5207")) return true; // {name=c13") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Other Street") && plz.equals("520745")) return true; // {name=c13") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Other Street"),
                                        () -> plz.equals("51688"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c14").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c15").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 479") && plz.equals("B5207")) return true; // {name=c15") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Street 479") && plz.equals("520745")) return true; // {name=c15") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Street 479"),
                                        () -> plz.equals("52066"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c16").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").withName("c17").by((String strasse, String plz) ->
                                {   if(strasse.equals("Street 481") && plz.equals("B5207")) return true; // {name=c17") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.
                                    if(strasse.equals("Street 481") && plz.equals("520745")) return true; // {name=c17") && parameterNames=(Komm-Strasse") && Komm-PLZ)}.

                                    return implies(() -> strasse.equals("Street 481"),
                                        () -> plz.equals("52074"));}
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").withName("c18").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                .build()
                ;
    }
}
