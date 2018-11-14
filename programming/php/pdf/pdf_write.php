<?php

date_default_timezone_set('Asia/Tokyo');

require_once(__DIR__.'/vendor/autoload.php');

$pdf = new FPDI();
$pdf->setSourceFile(__DIR__."/resources/test.pdf");
$pdf->addPage();
$importPage = $pdf->importPage(1);
$pdf->useTemplate($importPage, 0, 0);
$pdf->SetFont("kozminproregular", "", 12);
$pdf->Text(50, 100, "pdfにプログラムから書き込んでみる。");
$pdf->Image(__DIR__."/resources/test.jpg", 0, 0);
$pdf->Output(__DIR__."/tmp/output.pdf", "F");